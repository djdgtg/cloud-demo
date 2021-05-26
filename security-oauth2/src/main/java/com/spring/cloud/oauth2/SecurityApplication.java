package com.spring.cloud.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 *
 * @author qinchao
 * @date 2021/5/21 17:07
 */
@SpringBootApplication
@MapperScan("com.spring.cloud.oauth2.mapper")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
