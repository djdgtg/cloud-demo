package com.spring.cloud.sharding.entity;

import lombok.Data;

/**
 * Description ExamRecord
 *
 * @author qinchao
 * @date 2021/6/21 11:27
 */
@Data
public class ExamRecord {

    private Long id;

    private Integer studentId;

    private Integer examId;

}
