package com.spring.cloud.oauth2.vo;

import lombok.Data;

/**
 * Description ExamVO
 *
 * @author qinchao
 * @date 2021/5/12 14:46
 */
@Data
public class StudentImportVO {

    private String schoolCode;

    private String studentName;

    private String identityNumber;

    private String ticketNumber;

    private String examCode;

    private String siteNumber;

}
