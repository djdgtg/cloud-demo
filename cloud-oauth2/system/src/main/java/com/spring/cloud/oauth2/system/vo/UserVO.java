package com.spring.cloud.oauth2.system.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.spring.cloud.oauth2.system.entity.UserEntity;
import lombok.Data;

import java.util.List;

/**
 * Description UserVO
 *
 * @author qinchao
 * @date 2021/4/26 15:07
 */
@Data
public class UserVO extends UserEntity {

    @ExcelProperty(value = "角色", index = 5)
    private String roleNames;

    @ExcelIgnore
    private String roleIds;

    @ExcelIgnore
    private List<Integer> ids;

}
