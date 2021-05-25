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
@SpringBootApplication(scanBasePackages = {"com.spring.cloud"})
@MapperScan("com.spring.cloud.oauth2.mapper")
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
