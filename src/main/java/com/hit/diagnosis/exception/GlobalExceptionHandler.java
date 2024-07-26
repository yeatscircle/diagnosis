package com.hit.diagnosis.exception;

import com.hit.diagnosis.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionDisplay(Exception e){
        e.printStackTrace();
        return Result.error("程序错误:" + e.getMessage());
    }
}
