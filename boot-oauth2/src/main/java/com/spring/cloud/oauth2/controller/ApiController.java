package com.spring.cloud.oauth2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.Base64;

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

    @GetMapping("page/{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @Autowired
    private KeyPair keyPair;

    @GetMapping("rsa/publicKey")
    public String getKey() {
        byte[] bytes = Base64.getEncoder().encode(keyPair.getPublic().getEncoded());
        return StringUtils.toEncodedString(bytes, StandardCharsets.UTF_8);
    }

}
