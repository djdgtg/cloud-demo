package com.spring.cloud.oauth2.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Description RoleEntity
 *
 * @author qinchao
 * @date 2021/4/25 16:54
 */
@Data
@TableName("user_role")
public class UserRoleEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer roleId;

}
