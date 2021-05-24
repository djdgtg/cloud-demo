package com.spring.cloud.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.shiro.entity.UserEntity;

import java.util.Set;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    Set<String> getUserRoles(Integer userId);

    Set<String> getRolePermissions(Integer userId);

}
