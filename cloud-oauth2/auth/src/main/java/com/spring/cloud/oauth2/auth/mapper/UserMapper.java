package com.spring.cloud.oauth2.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.oauth2.auth.entity.UserEntity;

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
     * @return java.util.List<java.lang.String>
     * @author qinchao
     * @date 2021/4/22 15:20
     */
    List<String> getUserAuthorities(Integer userId);
}
