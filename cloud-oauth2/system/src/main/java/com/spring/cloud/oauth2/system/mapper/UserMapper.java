package com.spring.cloud.oauth2.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.UserEntity;
import com.spring.cloud.oauth2.system.vo.UserImportVO;
import com.spring.cloud.oauth2.system.vo.UserVO;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;
import java.util.Map;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    Page<UserVO> getPage(PageVO<UserVO> pageVO);

    List<UserVO> getList(Map<String,Object> query);

    void importBatch(List<UserImportVO> list);

}
