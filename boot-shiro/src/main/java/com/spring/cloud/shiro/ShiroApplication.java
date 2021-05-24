package com.spring.cloud.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description 启动类
 *
 * @author qinchao
 * @date 2021/2/2 14:24
 */
@SpringBootApplication
@MapperScan("com.spring.cloud.shiro.mapper")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }

}
