package com.spring.cloud.oauth2.gateway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description ResourceEntity
 *
 * @author qinchao
 * @date 2021/4/20 16:46
 */
@TableName("resource")
@Data
public class ResourceEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String resourceName;

    private String url;

    private String method;

    private Boolean permitAll;

    private static final long serialVersionUID = 1L;
}
