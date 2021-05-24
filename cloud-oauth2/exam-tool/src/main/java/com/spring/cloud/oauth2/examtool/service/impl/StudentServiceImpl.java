package com.spring.cloud.oauth2.examtool.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.examtool.entity.Discipline;
import com.spring.cloud.oauth2.examtool.entity.ErrorType;
import com.spring.cloud.oauth2.examtool.entity.Student;
import com.spring.cloud.oauth2.examtool.mapper.DisciplineMapper;
import com.spring.cloud.oauth2.examtool.mapper.ErrorTypeMapper;
import com.spring.cloud.oauth2.examtool.mapper.StudentMapper;
import com.spring.cloud.oauth2.examtool.service.StudentService;
import com.spring.cloud.oauth2.examtool.vo.StudentImportVO;
import com.spring.cloud.oauth2.examtool.vo.StudentStatisticsQueryVO;
import com.spring.cloud.oauth2.examtool.vo.StudentStatisticsVO;
import com.spring.cloud.oauth2.examtool.vo.StudentVO;
import com.spring.cloud.web.bean.PageVO;
import com.spring.cloud.web.utils.ExcelUtils;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ExcelUtils excelUtils;

    @Autowired
    private DisciplineMapper disciplineMapper;

    @Autowired
    private ErrorTypeMapper errorTypeMapper;

    @Override
    public Student getById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public StudentVO info(String schoolCode, String examCode, String siteNumber) {
        return studentMapper.info(schoolCode, examCode, siteNumber);
    }

    @Override
    public Page<StudentVO> page(PageVO<StudentVO> pageVO) {
        return studentMapper.page(pageVO);
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            studentMapper.insert(student);
        } else {
            studentMapper.updateById(student);
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            studentMapper.deleteBatchIds(list);
        }
    }

    @Override
    public void export(StudentVO student) {
        Map<String, Object> map = new HashMap<>();
        map.put("query", student);
        List<StudentVO> list = studentMapper.list(map);
        excelUtils.export(list, "考生导出", StudentVO.class);
    }

    @Override
    public void imports(MultipartFile file) {
        List<StudentImportVO> list = excelUtils.getList(file, StudentImportVO.class);
        studentMapper.saveBatch(list);
    }

    @Override
    public void template() {
        excelUtils.exportFile("templates/student-import-template.xlsx");
    }

    @Override
    public Page<StudentStatisticsVO> statistics(PageVO<StudentStatisticsQueryVO> pageVO) {
        return studentMapper.statistics(pageVO);
    }

    @Override
    public List<Discipline> disciplines() {
        return disciplineMapper.selectList(null);
    }

    @Override
    public List<ErrorType> errors() {
        return errorTypeMapper.selectList(null);
    }

}
