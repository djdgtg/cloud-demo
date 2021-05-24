package com.spring.cloud.oauth2.examtool.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * disciplinary
 *
 * @author
 */
@Data
public class Discipline implements Serializable {

    private Integer id;

    private String source;

    private String disciplineCode;

    private String disciplineDetail;

    private String punishment;

    private static final long serialVersionUID = 1L;

}