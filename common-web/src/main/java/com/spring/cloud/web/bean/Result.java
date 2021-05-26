package com.spring.cloud.web.bean;

import lombok.Data;

import java.io.Serializable;


/**
 * description Result
 *
 * @author qinc
 * @date 2018/12/11
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -6614400429699484429L;

    private Integer code;

    private String message;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
