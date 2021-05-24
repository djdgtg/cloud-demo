package com.spring.cloud.oauth2.examtool.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.spring.cloud.oauth2.examtool.entity.Exam;
import lombok.Data;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class ExamVO extends Exam {

    @ExcelProperty(value = "学校名称", index = 4)
    private String schoolName;

    @ExcelProperty(value = "参考人数", index = 8)
    private Integer attendNumber;

}
