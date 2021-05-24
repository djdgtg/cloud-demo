package com.spring.cloud.oauth2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.spring.cloud.oauth2.entity.UserEntity;
import com.spring.cloud.oauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * description 自定义返回token相关信息，去掉该类即使用oauth2的默认的登陆方式
 *
 * @author qinchao
 * @date 2021/3/15 15:24
 */
@RestController
@RequestMapping("oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private UserMapper userMapper;

    @PostMapping( "/token")
    public AuthVO postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        ResponseEntity<OAuth2AccessToken> responseEntity = tokenEndpoint.postAccessToken(principal, parameters);
        OAuth2AccessToken accessToken = responseEntity.getBody();
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getUsername,parameters.get("username"))
                .eq(UserEntity::getPassword,parameters.get("password"));
        UserEntity userEntity = userMapper.selectOne(wrapper);
        AuthVO authVO = new AuthVO();
        authVO.setToken(accessToken.getValue());
        authVO.setUserinfo(userEntity);
        return authVO;
    }

}
