package com.spring.cloud.oauth2.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.RoleEntity;
import com.spring.cloud.oauth2.system.service.RoleService;
import com.spring.cloud.oauth2.system.vo.RoleVO;
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
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleEntity> roles() {
        return roleService.roles();
    }

    @PostMapping
    public void save(@RequestBody RoleVO roleVO) {
        roleService.save(roleVO);
    }

    @PostMapping("page")
    public Page<RoleVO> page(@RequestBody PageVO<RoleVO> pageVO) {
        return roleService.page(pageVO);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        roleService.delete(ids);
    }

}
