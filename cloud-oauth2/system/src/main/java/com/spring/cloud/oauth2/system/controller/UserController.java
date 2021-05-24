package com.spring.cloud.oauth2.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.service.UserService;
import com.spring.cloud.oauth2.system.vo.UserVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 16:23
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody UserVO userVO) {
        userService.save(userVO);
    }

    @PostMapping("page")
    public Page<UserVO> page(@RequestBody PageVO<UserVO> pageVO) {
        return userService.page(pageVO);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        userService.delete(ids);
    }

    @PostMapping("export")
    public void export(@RequestBody UserVO userVO) {
        userService.export(userVO);
    }

    @PostMapping("import")
    public void imports(MultipartFile file) {
        userService.imports(file);
    }

    @GetMapping("template")
    public void template() {
        userService.template();
    }

    @PostMapping("enabled/{enabled}")
    public void enabled(@PathVariable Boolean enabled, @RequestBody List<Integer> ids) {
        userService.enabled(enabled, ids);
    }

}
