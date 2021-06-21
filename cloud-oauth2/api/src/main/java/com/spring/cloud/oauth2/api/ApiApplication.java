package com.spring.cloud.oauth2.api;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 18:07
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableScheduling
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @GetMapping("{api}")
    public String api(@PathVariable String api) {
        return api;
    }

    @Scheduled(cron = "${task.cron}")
    public void task(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
