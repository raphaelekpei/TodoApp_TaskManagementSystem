package com.raphael.todoapp_taskmanagementsystem.controller;

import com.raphael.todoapp_taskmanagementsystem.exceptions.ApiError;
import com.raphael.todoapp_taskmanagementsystem.exceptions.TodoManagementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoManagementException.class)
    public ResponseEntity<?> TodoManagementExceptionHandler(TodoManagementException todoManagementException){
        ApiError apiError = ApiError.builder()
                .isSuccessful(false)
                .timeStamp(LocalDateTime.now())
                .message(todoManagementException.getMessage())
                .build();
//        ApiError apiError1 = new ApiError();
//        apiError1.setSuccessful(false);
//        apiError1.setTimeStamp(LocalDateTime.now());
//        apiError1.setMessage(todoManagementException.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


}
