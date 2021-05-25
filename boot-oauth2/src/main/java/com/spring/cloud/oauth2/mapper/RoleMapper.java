package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.RoleEntity;
import com.spring.cloud.oauth2.vo.RoleVO;
import com.spring.cloud.web.bean.PageVO;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface RoleMapper extends BaseMapper<RoleEntity> {

    Page<RoleVO> getPage(PageVO<RoleVO> pageVO, RoleVO roleVO);

}
