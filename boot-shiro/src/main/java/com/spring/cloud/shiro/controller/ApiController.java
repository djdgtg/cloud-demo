package com.spring.cloud.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description 对外提供公钥访问的接口
 *
 * @author qinchao
 * @date 2021/3/15 15:24
 */
@RestController
public class ApiController {

    @GetMapping("api/{api}")
    public String api(@PathVariable String api) {
        return api;
    }

}
