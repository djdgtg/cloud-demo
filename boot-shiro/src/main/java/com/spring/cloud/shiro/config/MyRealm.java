package com.spring.cloud.shiro.config;

import com.spring.cloud.shiro.entity.UserEntity;
import com.spring.cloud.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description 自定义realm,进行认证和授权
 *
 * @author qinchao
 * @date 2020/12/2 18:06
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * Description 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        UserEntity user = userService.auth(username, password);
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    /**
     * Description 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户
        UserEntity user = (UserEntity) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            //添加角色
            simpleAuthorizationInfo.addRoles(userService.getUserRoles(user.getId()));
            //添加权限
            simpleAuthorizationInfo.addStringPermissions(userService.getRolePermissions(user.getId()));
            return simpleAuthorizationInfo;
        }
        return null;
    }
}
