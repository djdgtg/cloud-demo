package com.spring.cloud.oauth2.examtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description 
 * 
 * @author qinchao
 * @date 2021/5/8 17:41 
 */
@SpringBootApplication(scanBasePackages = {"com.spring.cloud"})
@EnableDiscoveryClient
@MapperScan("com.spring.cloud.oauth2.examtool.mapper")
public class ExamToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamToolApplication.class, args);
    }

}
