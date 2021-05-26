package com.spring.cloud.oauth2.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description LoginController
 *
 * @author qinchao
 * @date 2021/4/22 17:57
 */
@RestController
@RequestMapping("page")
public class PageController {

    @GetMapping("{path}")
    public String page(@PathVariable String path) {
        return path;
    }
}
