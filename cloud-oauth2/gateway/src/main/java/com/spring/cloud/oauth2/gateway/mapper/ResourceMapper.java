package com.spring.cloud.oauth2.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.oauth2.gateway.entity.ResourceEntity;

import java.util.List;

/**
 * description ResourceMapper
 *
 * @author qinchao
 * @date 2021/4/20 16:48
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    /**
     * Description 如果一个url跟method匹配到多个会报错
     *
     * @param method 请求方式
     * @param url    url
     * @return com.spring.cloud.gateway.entity.ResourceEntity
     * @author qinchao
     * @date 2021/4/28 14:30
     */
    ResourceEntity getResourceEntity(String method, String url);

    /**
     * Description 获取资源所能访问的权限
     *
     * @param resourceId
     * @return java.util.List<java.lang.String>
     * @author qinchao
     * @date 2021/4/28 14:31
     */
    List<String> getAccessAuthorities(Integer resourceId);

}
