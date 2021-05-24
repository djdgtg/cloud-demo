package com.spring.cloud.web.exception.handler;

import com.spring.cloud.web.bean.Result;
import com.spring.cloud.web.exception.StatusException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qinchao
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseEntity<Result> exception(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new Result(HttpStatus.BAD_REQUEST.value(),e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<Result> status(StatusException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new Result(e.getStatus() ,e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}