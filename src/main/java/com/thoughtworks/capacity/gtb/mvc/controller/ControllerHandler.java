package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.exception.CommentError;
import com.thoughtworks.capacity.gtb.mvc.exception.PasswordException;
import com.thoughtworks.capacity.gtb.mvc.exception.RepeatNameException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerHandler {


    @ExceptionHandler(RepeatNameException.class)
    public ResponseEntity<CommentError> handleException(RepeatNameException ex) {
        CommentError repeatNameError = new CommentError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(repeatNameError);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommentError> handleException(MethodArgumentNotValidException ex) {
        CommentError notValidError = new CommentError(HttpStatus.BAD_REQUEST.value(), ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notValidError);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<CommentError> handleException(UserNotExistException ex) {
        CommentError userNotExistError = new CommentError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotExistError);
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<CommentError> handleException(PasswordException ex) {
        CommentError passwordExistError = new CommentError(HttpStatus.FORBIDDEN.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(passwordExistError);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<CommentError> handleException(ConstraintViolationException ex) {
        CommentError notValidError = new CommentError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notValidError);
    }
}

