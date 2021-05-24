package com.spring.cloud.oauth2.examtool.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Description StudentAbsentVO
 *
 * @author qinchao
 * @date 2021/5/17 17:08
 */
@Data
public class StudentDisciplineVO {

    @ExcelProperty(value = "序号", index = 0)
    private Integer id;

    @ExcelProperty(value = "准考证号", index = 1)
    private String ticketNumber;

    @ExcelProperty(value = "姓名", index = 2)
    private String studentName;

    @ExcelProperty(value = "考场号", index = 3)
    private String examCode;

    @ExcelProperty(value = "座位号", index = 4)
    private String siteNumber;

    @ExcelProperty(value = "违纪条款", index = 5)
    private String disciplineCode;

}
