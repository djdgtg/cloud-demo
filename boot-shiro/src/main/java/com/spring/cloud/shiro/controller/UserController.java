package com.spring.cloud.shiro.controller;

import com.spring.cloud.shiro.entity.UserEntity;
import com.spring.cloud.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description UserController
 *
 * @author qinchao
 * @since 2020-12-01 14:45:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "login")
    public UserEntity login(String username, String password) {
        UserEntity login = userService.auth(username, password);
        if (login == null) {
            throw new RuntimeException("账号或者密码不正确");
        } else {
            // 添加用户认证信息
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            // 进行验证，这里可以捕获异常，然后返回对应信息
            SecurityUtils.getSubject().login(usernamePasswordToken);
            return login;
        }
    }
}