package com.spring.cloud.oauth2.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * description UserEntity
 *
 * @author qinchao
 * @date 2021/4/20 15:46
 */
@Data
public class UserImportVO {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "用户名", index = 1)
    private String username;

    @ExcelProperty(value = "密码", index = 2)
    private String password;

    @ExcelProperty(value = "是否开启", index = 3)
    private Boolean enabled;

}
