package com.spring.cloud.oauth2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description UserEntity
 *
 * @author qinchao
 * @date 2021/4/20 15:46
 */
@Data
@TableName("user")
public class UserEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String username;

    private String password;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}
