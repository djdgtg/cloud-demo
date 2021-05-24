package com.spring.cloud.oauth2.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description 该工程只做身份认证（返回access_token，token携带用户权限信息）、提供publicKey
 *
 * @author qinchao
 * @date 2021/4/27 11:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.spring.cloud.oauth2.auth.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
