package com.spring.cloud.oauth2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.Discipline;
import com.spring.cloud.oauth2.entity.ErrorType;
import com.spring.cloud.oauth2.entity.Student;
import com.spring.cloud.oauth2.service.StudentService;
import com.spring.cloud.oauth2.vo.StudentStatisticsQueryVO;
import com.spring.cloud.oauth2.vo.StudentStatisticsVO;
import com.spring.cloud.oauth2.vo.StudentVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("examtool/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("{id}")
    public Student getById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping("info")
    public StudentVO info(@RequestParam String schoolCode, @RequestParam String examCode,
                          @RequestParam String siteNumber) {
        return studentService.info(schoolCode, examCode, siteNumber);
    }

    @PostMapping("page")
    public Page<StudentVO> page(@RequestBody PageVO<StudentVO> pageVO) {
        return studentService.page(pageVO);
    }

    @PostMapping("statistics")
    public Page<StudentStatisticsVO> statistics(@RequestBody PageVO<StudentStatisticsQueryVO> pageVO) {
        return studentService.statistics(pageVO);
    }

    @PostMapping
    public void save(@RequestBody StudentVO student) {
        studentService.save(student);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        studentService.delete(ids);
    }

    @PostMapping("export")
    public void export(@RequestBody StudentVO student) {
        studentService.export(student);
    }

    @PostMapping("import")
    public void imports(MultipartFile file) {
        studentService.imports(file);
    }

    @GetMapping("template")
    public void template() {
        studentService.template();
    }

    @GetMapping("disciplines")
    public List<Discipline> disciplines() {
        return studentService.disciplines();
    }

    @GetMapping("errors")
    public List<ErrorType> errors() {
        return studentService.errors();
    }

}
