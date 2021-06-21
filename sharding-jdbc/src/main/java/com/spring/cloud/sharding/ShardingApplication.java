package com.spring.cloud.sharding;

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
@MapperScan("com.spring.cloud.sharding.mapper")
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }

}
