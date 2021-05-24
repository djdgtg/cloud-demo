package com.spring.cloud.oauth2.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.system.entity.ResourceEntity;
import com.spring.cloud.oauth2.system.vo.ResourceVO;
import com.spring.cloud.web.bean.PageVO;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    Page<ResourceVO> getPage(PageVO<ResourceVO> pageVO, ResourceVO resourceVO);
}
