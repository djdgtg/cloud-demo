package com.spring.cloud.oauth2.examtool.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * error_type
 *
 * @author
 */
@Data
public class ErrorType implements Serializable {
    private Integer id;

    private String errorName;

    private static final long serialVersionUID = 1L;
}