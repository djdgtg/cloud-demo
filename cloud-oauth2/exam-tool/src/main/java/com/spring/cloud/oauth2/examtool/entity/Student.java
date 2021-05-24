package com.spring.cloud.oauth2.examtool.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * student
 *
 * @author
 */
@Data
public class Student implements Serializable {

    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "ID", index = 0)
    private Integer id;

    @ExcelProperty(value = "考生姓名", index = 1)
    private String studentName;

    @ExcelProperty(value = "密码", index = 2)
    private String password;

    @ExcelProperty(value = "身份证号", index = 3)
    private String identityNumber;

    @ExcelProperty(value = "准考证号", index = 4)
    private String ticketNumber;

    @ExcelProperty(value = "座位号", index = 5)
    private String siteNumber;

    @ExcelProperty(value = "学校编码", index = 6)
    private String schoolCode;

    @ExcelProperty(value = "考场编码", index = 8)
    private String examCode;

    @ExcelIgnore
    private Integer errorType;

    @ExcelProperty(value = "违纪编码", index = 12)
    private String disciplineCode;

    @ExcelProperty(value = "异常说明", index = 13)
    private String remark;

    @ExcelProperty(value = "处理结果", index = 14)
    private String actionRemark;

    private static final long serialVersionUID = 1L;

}