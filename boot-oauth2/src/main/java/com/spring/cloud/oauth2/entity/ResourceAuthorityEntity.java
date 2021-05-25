package com.spring.cloud.oauth2.entity;

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
@TableName("resource_authority")
public class ResourceAuthorityEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer resourceId;

    private Integer authorityId;

}
