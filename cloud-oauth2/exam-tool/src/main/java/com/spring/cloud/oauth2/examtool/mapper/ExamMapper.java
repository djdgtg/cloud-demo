package com.spring.cloud.oauth2.examtool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.examtool.entity.Exam;
import com.spring.cloud.oauth2.examtool.vo.ExamImportVO;
import com.spring.cloud.oauth2.examtool.vo.ExamVO;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;
import java.util.Map;

public interface ExamMapper extends BaseMapper<Exam> {

    Page<ExamVO> page(PageVO<Exam> pageVO);

    List<ExamVO> list(Map<String, Object> map);

    void saveBatch(List<ExamImportVO> list);

}