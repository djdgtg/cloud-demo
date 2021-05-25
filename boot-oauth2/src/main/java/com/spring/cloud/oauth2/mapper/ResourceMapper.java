package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.cloud.oauth2.entity.ResourceEntity;
import com.spring.cloud.oauth2.vo.ResourceVO;
import com.spring.cloud.web.bean.PageVO;

import java.util.List;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    Page<ResourceVO> getPage(PageVO<ResourceVO> pageVO, ResourceVO resourceVO);

    ResourceEntity getResourceEntity(String method, String url);

    List<String> getAccessAuthorities(Integer resourceId);

}
