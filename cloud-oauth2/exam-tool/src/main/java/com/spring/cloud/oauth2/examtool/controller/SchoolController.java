package com.spring.cloud.oauth2.examtool.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.examtool.entity.School;
import com.spring.cloud.oauth2.examtool.service.SchoolService;
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
 * Description StudentController
 *
 * @author qinchao
 * @date 2021/5/12 14:19
 */
@RestController
@RequestMapping("school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("{id}")
    public School getById(@PathVariable Integer id) {
        return schoolService.getById(id);
    }

    @GetMapping
    public List<School> list() {
        return schoolService.list();
    }

    @PostMapping("page")
    public Page<School> page(@RequestBody PageVO<School> page) {
        return schoolService.page(page);
    }

    @PostMapping
    public void save(@RequestBody School school) {
        schoolService.save(school);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        schoolService.delete(ids);
    }

    @PostMapping("export")
    public void export(@RequestBody School school) {
        schoolService.export(school);
    }

    @PostMapping("import")
    public void imports(MultipartFile file) {
        schoolService.imports(file);
    }

    @GetMapping("template")
    public void template() {
        schoolService.template();
    }

}
