package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.oauth2.entity.School;
import com.spring.cloud.oauth2.vo.SchoolImportVO;

import java.util.List;

public interface SchoolMapper extends BaseMapper<School> {

    void saveBatch(List<SchoolImportVO> list);

}