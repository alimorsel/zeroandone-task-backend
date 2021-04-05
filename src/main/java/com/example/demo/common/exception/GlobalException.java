package com.example.demo.common.exception;
import lombok.Getter;
import lombok.Setter;
import org.cef.handler.CefLoadHandler;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class GlobalException extends RuntimeException {
    String message;
    HttpStatus httpStatus;
    Map<String,String> errors;

    public GlobalException(String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public GlobalException(String message, HttpStatus httpStatus, Map<String,String> errors) {
        this.errors=errors;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}

