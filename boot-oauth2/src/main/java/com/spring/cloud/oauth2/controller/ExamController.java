package com.spring.cloud.oauth2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.Exam;
import com.spring.cloud.oauth2.service.ExamService;
import com.spring.cloud.oauth2.vo.ExamVO;
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
@RequestMapping("examtool/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("page")
    public Page<ExamVO> page(@RequestBody PageVO<Exam> pageVO) {
        return examService.page(pageVO);
    }

    @PostMapping
    public void save(@RequestBody ExamVO exam) {
        examService.save(exam);
    }

    @DeleteMapping("{ids}")
    public void delete(@PathVariable String ids) {
        examService.delete(ids);
    }

    @PostMapping("export")
    public void export(@RequestBody Exam exam) {
        examService.export(exam);
    }

    @PostMapping("import")
    public void imports(MultipartFile file) {
        examService.imports(file);
    }

    @GetMapping("template")
    public void template() {
        examService.template();
    }

    @GetMapping("examCode")
    public List<Exam> examCode(String schoolCode) {
        return examService.examCode(schoolCode);
    }

}
