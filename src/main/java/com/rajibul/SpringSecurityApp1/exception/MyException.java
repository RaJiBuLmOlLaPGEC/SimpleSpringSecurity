package com.rajibul.SpringSecurityApp1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
