package com.spring.cloud.shiro.exception;

/**
 * description
 *
 * @author qinchao
 */
public class StatusException extends RuntimeException {

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public StatusException(Integer status) {
        super();
        this.status = status;
    }

    public StatusException(Integer status, Throwable cause) {
        super(cause);
        this.status = status;
    }

    public StatusException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public StatusException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

}