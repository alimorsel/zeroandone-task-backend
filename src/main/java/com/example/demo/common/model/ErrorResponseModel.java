package com.example.demo.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class ErrorResponseModel {
    private String message;
    private String code;

    private Map<String,String> errors;


    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public ErrorResponseModel(String message, String code, Map<String, String> errors) {
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    public ErrorResponseModel(String message, String code) {
        this.message = message;
        this.code = code;
    }



}

