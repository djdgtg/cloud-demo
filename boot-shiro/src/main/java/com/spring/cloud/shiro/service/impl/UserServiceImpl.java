package com.spring.cloud.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.spring.cloud.shiro.entity.ResourceEntity;
import com.spring.cloud.shiro.entity.UserEntity;
import com.spring.cloud.shiro.mapper.ResourceMapper;
import com.spring.cloud.shiro.mapper.UserMapper;
import com.spring.cloud.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * description shiro注入service会使该service的AOP失效，
 * 因此，把shiro相关的代码提出来，避免影响其他业务
 *
 * @author qinchao
 * @date 2021/1/21 17:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Map<String, String> loadShiroFilter() {
        Map<String, String> map = new LinkedHashMap<>();
        //登出
        map.put("/logout", "logout");
        //登陆及静态资源放行
        map.put("/user/login", "anon");
        map.put("/css/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/img/**", "anon");
        map.put("/js/**", "anon");
        map.put("/plugins/**", "anon");
        List<ResourceEntity> list = resourceMapper.selectList(null);
        if (list != null) {
            for (ResourceEntity entity : list) {
                List<String> authorities = resourceMapper.getAccessAuthorities(entity.getId());
                if (authorities!=null) {
                    StringJoiner sj = new StringJoiner(",","perms[","]");
                    for (String authority : authorities) {
                        sj.add(authority);
                    }
                    map.put(entity.getUrl(), sj.toString());
                }
            }
        }
        //对所有用户认证
        map.put("/**", "authc");
        return map;
    }

    @Override
    public UserEntity auth(String username, String password) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getUsername, username).eq(UserEntity::getPassword, password);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public Set<String> getUserRoles(Integer userId) {
        return userMapper.getUserRoles(userId);
    }

    @Override
    public Set<String> getRolePermissions(Integer userId) {
        return userMapper.getRolePermissions(userId);
    }
}
