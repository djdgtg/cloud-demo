package com.spring.cloud.oauth2.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * school
 *
 * @author
 */
@Data
public class School implements Serializable {

    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "ID", index = 0)
    private Integer id;

    @ExcelProperty(value = "学校编码", index = 1)
    private String schoolCode;

    @ExcelProperty(value = "学校名称", index = 2)
    private String schoolName;

    private static final long serialVersionUID = 1L;

}