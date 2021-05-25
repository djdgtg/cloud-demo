package com.spring.cloud.oauth2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.Discipline;
import com.spring.cloud.oauth2.entity.ErrorType;
import com.spring.cloud.oauth2.entity.Student;
import com.spring.cloud.oauth2.vo.StudentStatisticsQueryVO;
import com.spring.cloud.oauth2.vo.StudentStatisticsVO;
import com.spring.cloud.oauth2.vo.StudentVO;
import com.spring.cloud.web.bean.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description StudentService
 *
 * @author qinchao
 * @date 2021/5/12 14:21
 */
public interface StudentService {

    Student getById(Integer id);

    StudentVO info(String schoolCode, String examCode, String siteNumber);

    Page<StudentVO> page(PageVO<StudentVO> pageVO);

    void save(Student student);

    void delete(String ids);

    void export(StudentVO student);

    void imports(MultipartFile file);

    void template();

    Page<StudentStatisticsVO> statistics(PageVO<StudentStatisticsQueryVO> pageVO);

    List<Discipline> disciplines();

    List<ErrorType> errors();

}
