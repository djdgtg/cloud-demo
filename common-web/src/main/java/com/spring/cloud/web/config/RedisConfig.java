package com.spring.cloud.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * description RedisConfig
 *
 * @author qinchao
 * @date 2020/12/3 10:24
 */
@Configuration
public class RedisConfig {

    public static final Integer CACHE_REDIS_DURATION = 3600 * 24 * 2;

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory
            , RedisSerializer<Object> valueSerializer, StringRedisSerializer keySerializer) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                //缓存过期时间，2天
                .entryTtl(Duration.ofSeconds(CACHE_REDIS_DURATION))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer))
                .disableCachingNullValues();
        return RedisCacheManager.builder(factory).cacheDefaults(config).transactionAware().build();
    }

    @Bean
    public RedisSerializer<Object> valueSerializer(@Qualifier("redisObjectMapper") ObjectMapper objectMapper) {
        return new GenericJackson2JsonRedisSerializer(objectMapper);
    }

    @Bean
    public StringRedisSerializer keySerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory
            , RedisSerializer<Object> valueSerializer, StringRedisSerializer keySerializer) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(keySerializer);
        template.setValueSerializer(valueSerializer);
        template.setHashKeySerializer(keySerializer);
        template.setHashValueSerializer(valueSerializer);
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean
    public RedisTemplate<String, Integer> redisTemplate(RedisConnectionFactory factory
            , StringRedisSerializer keySerializer) {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        template.setConnectionFactory(factory);
        return template;
    }

}
