package com.spring.cloud.oauth2.controller;

import com.spring.cloud.oauth2.entity.UserEntity;
import lombok.Data;

/**
 * Description AuthVO
 *
 * @author qinchao
 * @date 2021/5/24 17:05
 */
@Data
public class AuthVO {

    private String token;

    private UserEntity userinfo;

}
