package com.spring.cloud.oauth2.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 18:07
 */
@SpringBootApplication(scanBasePackages = {"com.spring.cloud"})
@EnableDiscoveryClient
@MapperScan("com.spring.cloud.oauth2.system.mapper")
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
