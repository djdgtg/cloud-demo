package com.spring.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.spring.cloud.oauth2.entity.UserEntity;
import com.spring.cloud.oauth2.mapper.UserMapper;
import com.spring.cloud.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description JdbcUserDetailsServiceImpl
 *
 * @author qinchao
 * @date 2021/3/12 14:32
 */
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getUsername, username);
        UserEntity userEntity = userMapper.selectOne(wrapper);
        if (userEntity == null) {
            throw new InvalidGrantException("用户名或密码错误");
        }
        List<String> userAuthorities = userMapper.getUserAuthorities(userEntity.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        userAuthorities.forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority)));
        return new User(username, passwordEncoder.encode(userEntity.getPassword()), authorities);
    }

}
