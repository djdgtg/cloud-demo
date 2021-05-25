package com.spring.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.School;
import com.spring.cloud.oauth2.mapper.SchoolMapper;
import com.spring.cloud.oauth2.service.SchoolService;
import com.spring.cloud.oauth2.vo.SchoolImportVO;
import com.spring.cloud.web.bean.PageVO;
import com.spring.cloud.web.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * Description SchoolServiceImpl
 *
 * @author qinchao
 * @date 2021/5/12 16:49
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private ExcelUtils excelUtils;

    @Override
    public School getById(Integer id) {
        return schoolMapper.selectById(id);
    }

    @Override
    public Page<School> page(PageVO<School> page) {
        LambdaQueryWrapper<School> wrapper = getWrapper(page.getQuery());
        return schoolMapper.selectPage(page, wrapper);
    }

    private LambdaQueryWrapper<School> getWrapper(School school) {
        LambdaQueryWrapper<School> wrapper = new LambdaQueryWrapper<>();
        if (school != null && StringUtils.hasText(school.getSchoolName())) {
            wrapper.eq(School::getSchoolName, school.getSchoolName());
        }
        if (school != null && StringUtils.hasText(school.getSchoolCode())) {
            wrapper.eq(School::getSchoolCode, school.getSchoolCode());
        }
        return wrapper;
    }

    @Override
    public List<School> list() {
        return schoolMapper.selectList(null);
    }

    @Override
    public void save(School school) {
        if (school.getId() == null) {
            schoolMapper.insert(school);
        } else {
            schoolMapper.updateById(school);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        if (!CollectionUtils.isEmpty(list)) {
            schoolMapper.deleteBatchIds(list);
        }
    }

    @Override
    public void export(School school) {
        List<School> list = schoolMapper.selectList(getWrapper(school));
        excelUtils.export(list, "学校导出", School.class);
    }

    @Override
    public void imports(MultipartFile file) {
        List<SchoolImportVO> list = excelUtils.getList(file, SchoolImportVO.class);
        schoolMapper.saveBatch(list);
    }

    @Override
    public void template() {
        excelUtils.exportFile("templates/school-import-template.xlsx");
    }
}
