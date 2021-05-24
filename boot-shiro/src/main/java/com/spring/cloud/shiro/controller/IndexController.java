package com.spring.cloud.shiro.controller;

import com.spring.cloud.shiro.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description IndexController
 *
 * @author qinchao
 * @date 2021/2/2 15:54
 */
@Controller
public class IndexController {


    @GetMapping("{page}")
    public String page(@PathVariable String page, Model model) {
        UserEntity principal = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            model.addAttribute("user", principal);
        }
        return page;
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void favicon() {
    }

}