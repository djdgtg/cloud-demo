package com.spring.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.oauth2.entity.UserEntity;

import java.util.List;

/**
 * description UserMapper
 *
 * @author qinchao
 * @date 2021/4/20 15:47
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * Description 根据用户id获取其权限
     * 
     * @param userId 
     * @author qinchao 
     * @date 2021/4/22 15:20
     * @return java.util.List<java.lang.String>
     */
    List<String> getUserAuthorities(Integer userId);
}