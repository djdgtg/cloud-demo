package com.spring.cloud.oauth2.examtool.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.examtool.entity.Exam;
import com.spring.cloud.oauth2.examtool.vo.ExamVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description StudentService
 *
 * @author qinchao
 * @date 2021/5/12 14:21
 */
public interface ExamService {

    Page<ExamVO> page(PageVO<Exam> pageVO);

    List<Exam> list();

    void save(Exam exam);

    void delete(String ids);

    void export(Exam exam);

    void imports(MultipartFile file);

    void template();

    List<Exam> examCode(String schoolCode);
}
