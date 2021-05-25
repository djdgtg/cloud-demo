package com.spring.cloud.oauth2.vo;

import lombok.Data;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class StudentStatisticsQueryVO {

    private String examCode;

    private String schoolCode;

    private Integer type;

}
