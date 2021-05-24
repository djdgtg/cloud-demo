package com.spring.cloud.web.aspect;

import com.google.common.collect.ImmutableList;
import com.spring.cloud.web.aspect.enums.Limit;
import com.spring.cloud.web.exception.StatusException;
import com.spring.cloud.web.utils.HttpServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * description 限流的切面
 *
 * @author qinchao
 * @date 2021/1/14 18:00
 */
@Component
@Aspect
public class LimitingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LimitingAspect.class);

    private final RedisTemplate<String, Object> limitRedisTemplate;

    public LimitingAspect(RedisTemplate<String, Object> limitRedisTemplate) {
        this.limitRedisTemplate = limitRedisTemplate;
    }

    @Before("@annotation(com.spring.cloud.web.aspect.enums.Limit) && @annotation(limit)")
    public void limit(Limit limit) {
        String name = limit.name();
        String key = HttpServletUtils.getIpAddress();
        int limitPeriod = limit.period();
        int limitCount = limit.count();
        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limit.prefix(), key));
        String luaScript = buildLuaScript();
        RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
        Long count = limitRedisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
        logger.info("Access try count is {} for name = {} and key = {}", count, name, key);
        if (count == null || count > limitCount) {
            throw new StatusException(400, "The current request is restricted, please try again later");
        }
    }

    /**
     * 限流 脚本
     *
     * @return lua脚本
     */
    public String buildLuaScript() {
        StringBuilder lua = new StringBuilder();
        lua.append("local c");
        lua.append("\nc = redis.call('get',KEYS[1])");
        // 调用不超过最大值，则直接返回
        lua.append("\nif c and tonumber(c) > tonumber(ARGV[1]) then");
        lua.append("\nreturn c;");
        lua.append("\nend");
        // 执行计算器自加
        lua.append("\nc = redis.call('incr',KEYS[1])");
        lua.append("\nif tonumber(c) == 1 then");
        // 从第一次调用开始限流，设置对应键值的过期
        lua.append("\nredis.call('expire',KEYS[1],ARGV[2])");
        lua.append("\nend");
        lua.append("\nreturn c;");
        return lua.toString();
    }

}