package com.spring.cloud.oauth2.examtool.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class StudentStatisticsVO {

    @ExcelProperty(value = "学校名称", index = 0)
    private String schoolName;

    @ExcelProperty(value = "考场名称", index = 1)
    private String examName;

    @ExcelProperty(value = "参考人数", index = 2)
    private Integer attendNumber;

    @ExcelProperty(value = "总异常人数", index = 3)
    private Integer totalErrorNumber;

    @ExcelProperty(value = "缺考人数", index = 4)
    private Integer totalAbsentNumber;

    @ExcelProperty(value = "违纪人数", index = 5)
    private Integer totalDisciplinaryNumber;

    @ExcelProperty(value = "异常人数", index = 6)
    private Integer totalExceptionNumber;

    @ExcelIgnore
    private Integer type;

}
