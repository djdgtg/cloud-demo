package com.spring.cloud.oauth2.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.AuthorityEntity;
import com.spring.cloud.oauth2.system.service.AuthorityService;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 16:23
 */
@RestController
@RequestMapping("authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping
    public List<AuthorityEntity> authorities() {
        return authorityService.authorities();
    }

    @PostMapping
    public void save(@RequestBody AuthorityEntity authorityEntity) {
        authorityService.save(authorityEntity);
    }

    @PostMapping("page")
    public Page<AuthorityEntity> page(@RequestBody PageVO<AuthorityEntity> pageVO) {
        return authorityService.page(pageVO);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        authorityService.delete(ids);
    }

}
