package com.spring.cloud.oauth2.examtool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.examtool.entity.Exam;
import com.spring.cloud.oauth2.examtool.mapper.ExamMapper;
import com.spring.cloud.oauth2.examtool.service.ExamService;
import com.spring.cloud.oauth2.examtool.vo.ExamImportVO;
import com.spring.cloud.oauth2.examtool.vo.ExamVO;
import com.spring.cloud.web.bean.PageVO;
import com.spring.cloud.web.utils.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description StudentServiceImpl
 *
 * @author qinchao
 * @date 2021/5/12 14:22
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExcelUtils excelUtils;

    @Override
    public Page<ExamVO> page(PageVO<Exam> pageVO) {
        return examMapper.page(pageVO);
    }

    @Override
    public List<Exam> list() {
        return examMapper.selectList(null);
    }

    @Override
    public void save(Exam exam) {
        if (exam.getId() == null) {
            examMapper.insert(exam);
        } else {
            examMapper.updateById(exam);
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            examMapper.deleteBatchIds(list);
        }
    }

    @Override
    public void export(Exam exam) {
        Map<String, Object> map = new HashMap<>();
        map.put("query", exam);
        List<ExamVO> list = examMapper.list(map);
        excelUtils.export(list, "考场导出", ExamVO.class);
    }

    @Override
    public void imports(MultipartFile file) {
        List<ExamImportVO> list = excelUtils.getList(file, ExamImportVO.class);
        examMapper.saveBatch(list);
    }

    @Override
    public void template() {
        excelUtils.exportFile("templates/exam-import-template.xlsx");
    }

    @Override
    public List<Exam> examCode(String schoolCode) {
        LambdaQueryWrapper<Exam> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(schoolCode)) {
            wrapper.eq(Exam::getSchoolCode, schoolCode);
        }
        return examMapper.selectList(wrapper);
    }
}
