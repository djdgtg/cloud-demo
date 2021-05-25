package com.spring.cloud.oauth2.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class ExamImportVO {

    private String examName;

    private String schoolCode;

    private String examCode;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer duration;

}
