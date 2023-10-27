package com.catchtable.clone.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// HTTP 상태에 따라 AOP와 관련된 기능을 사용해서 처리하는건 바람직할까..?
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidRequestException(InvalidRequestException e) {
        return e.getMessage();
    }
}
