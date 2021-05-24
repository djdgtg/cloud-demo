package com.spring.cloud.oauth2.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.service.ResourceService;
import com.spring.cloud.oauth2.system.vo.ResourceVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * description
 *
 * @author qinchao
 * @date 2021/3/12 16:23
 */
@RestController
@RequestMapping("resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public void save(@RequestBody ResourceVO resourceVO) {
        resourceService.save(resourceVO);
    }

    @PostMapping("page")
    public Page<ResourceVO> page(@RequestBody PageVO<ResourceVO> pageVO) {
        return resourceService.page(pageVO);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        resourceService.delete(ids);
    }

}
