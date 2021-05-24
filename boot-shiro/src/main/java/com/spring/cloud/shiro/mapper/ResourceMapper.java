package com.spring.cloud.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.shiro.entity.ResourceEntity;

import java.util.List;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    List<String> getAccessAuthorities(Integer resourceId);

}
