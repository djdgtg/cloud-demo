package com.spring.cloud.oauth2.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description 权限控制交给该工程
 *
 * @author qinchao
 * @date 2021/4/27 16:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.spring.cloud.oauth2.gateway.mapper")
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
