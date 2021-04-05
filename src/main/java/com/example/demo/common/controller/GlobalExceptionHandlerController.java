package com.example.demo.common.controller;

import com.example.demo.common.exception.GlobalException;
import com.example.demo.common.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandlerController  {

    @ExceptionHandler({GlobalException.class})
    public final ResponseEntity<ErrorResponseModel> handleGlobalException(GlobalException ex, WebRequest request) {

        ErrorResponseModel errorResponseModel=new ErrorResponseModel(ex.getMessage(),ex.getHttpStatus().toString());
        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponseModel);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        Map<String,String> errors = new HashMap<String,String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {

            errors.put(violation.getPropertyPath().toString(),violation.getMessage());
        }

        ErrorResponseModel errorResponseModel =
                new ErrorResponseModel( "Validation failed",HttpStatus.BAD_REQUEST.toString(), errors);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseModel);

    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String,String> errors = new HashMap<String,String>();
        for (FieldError fieldError : ex.getFieldErrors()) {
//
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorResponseModel errorResponseModel =
                new ErrorResponseModel( "Validation failed",HttpStatus.BAD_REQUEST.toString(), errors);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseModel);

    }


    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ErrorResponseModel> handleAllExceptions(Exception ex, WebRequest request) {
        ex.printStackTrace();
        ErrorResponseModel errorResponseModel=new ErrorResponseModel(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseModel);
    }

}
