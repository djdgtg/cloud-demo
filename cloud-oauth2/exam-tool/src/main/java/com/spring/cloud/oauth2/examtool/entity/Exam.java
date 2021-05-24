package com.spring.cloud.oauth2.examtool.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * exam
 *
 * @author
 */
@Data
public class Exam implements Serializable {

    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "ID", index = 0)
    private Integer id;

    @ExcelProperty(value = "考场编码", index = 1)
    private String examCode;

    @ExcelProperty(value = "考场名称", index = 2)
    private String examName;

    @ExcelProperty(value = "学校编码", index = 3)
    private String schoolCode;

    @ExcelProperty(value = "考试开始时间", index = 5)
    private LocalDateTime startTime;

    @ExcelProperty(value = "考试结束时间", index = 6)
    private LocalDateTime endTime;

    @ExcelProperty(value = "考试时长", index = 7)
    private Integer duration;

    private static final long serialVersionUID = 1L;
}