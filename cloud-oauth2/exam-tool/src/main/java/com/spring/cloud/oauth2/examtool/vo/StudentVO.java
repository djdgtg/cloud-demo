package com.spring.cloud.oauth2.examtool.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.spring.cloud.oauth2.examtool.entity.Student;
import lombok.Data;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class StudentVO extends Student {

    @ExcelProperty(value = "学校名称", index = 7)
    private String schoolName;

    @ExcelProperty(value = "考场名称", index = 9)
    private String examName;

    @ExcelProperty(value = "异常类型", index = 10)
    private String errorName;

}
