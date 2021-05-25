package com.spring.cloud.oauth2.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
    @ExcelProperty(value = "序号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "用户名", index = 2)
    private String username;

    @ExcelProperty(value = "密码", index = 3)
    private String password;

    @ExcelProperty(value = "是否开启", index = 4)
    private Boolean enabled;

    private static final long serialVersionUID = 1L;
}
