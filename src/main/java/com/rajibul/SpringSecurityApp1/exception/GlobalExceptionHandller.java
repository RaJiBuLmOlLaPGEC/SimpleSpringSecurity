package com.rajibul.SpringSecurityApp1.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//@RestControllerAdvice
public class GlobalExceptionHandller {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MyException> allExceptionHandler(Exception e, WebRequest req){
//
//        MyException ex=new MyException();
//        ex.setTimeStamp(LocalDateTime.now());
//        ex.setMessage(e.getMessage());
//        ex.setDetails(req.getDescription(false));
//
//        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
