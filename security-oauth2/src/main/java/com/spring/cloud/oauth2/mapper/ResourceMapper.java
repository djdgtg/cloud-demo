package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.oauth2.entity.ResourceEntity;

import java.util.List;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    ResourceEntity getResourceEntity(String method, String url);

    List<String> getAccessAuthorities(Integer resourceId);

}
