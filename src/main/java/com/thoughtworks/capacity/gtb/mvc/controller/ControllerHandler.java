package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.exception.CommentError;
import com.thoughtworks.capacity.gtb.mvc.exception.RepeatNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {


    @ExceptionHandler(RepeatNameException.class)
    public ResponseEntity<CommentError> handleException(RepeatNameException ex) {
        CommentError repeatNameError = new CommentError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(repeatNameError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommentError> handleException(MethodArgumentNotValidException ex) {
        CommentError repeatNameError = new CommentError(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(repeatNameError);
    }

}
