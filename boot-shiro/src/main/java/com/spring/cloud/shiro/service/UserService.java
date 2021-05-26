package com.spring.cloud.shiro.service;


import com.spring.cloud.shiro.entity.UserEntity;

import java.util.Map;
import java.util.Set;

/**
 * description ShiroService
 *
 * @author qinchao
 * @date 2021/1/21 17:04
 */
public interface UserService {

    /**
     * Description 获取ShiroFilter的Map
     *
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author qinchao
     * @date 2021/2/3 17:46
     */
    Map<String, String> loadShiroFilter();

    /**
     * Description 校验身份
     *
     * @param username 用户名
     * @param password 密码
     * @return com.spring.boot.demo.entity.User
     * @author qinchao
     * @date 2021/2/3 17:47
     */
    UserEntity auth(String username, String password);

    /**
     * Description 获取角色
     *
     * @param id 用户id
     * @return java.util.Set<java.lang.String>
     * @author qinchao
     * @date 2021/2/3 17:47
     */
    Set<String> getUserRoles(Integer id);

    /**
     * Description 获取权限
     *
     * @param id 用户id
     * @return java.util.Set<java.lang.String>
     * @author qinchao
     * @date 2021/2/3 17:48
     */
    Set<String> getRolePermissions(Integer id);
}
