package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.Student;
import com.spring.cloud.oauth2.vo.StudentImportVO;
import com.spring.cloud.oauth2.vo.StudentStatisticsQueryVO;
import com.spring.cloud.oauth2.vo.StudentStatisticsVO;
import com.spring.cloud.oauth2.vo.StudentVO;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;
import java.util.Map;

public interface StudentMapper extends BaseMapper<Student> {

    Page<StudentVO> page(PageVO<StudentVO> pageVO);

    List<StudentVO> list(Map<String, Object> map);

    void saveBatch(List<StudentImportVO> list);

    Page<StudentStatisticsVO> statistics(PageVO<StudentStatisticsQueryVO> pageVO);

    StudentVO info(String schoolCode, String examCode, String siteNumber);
}