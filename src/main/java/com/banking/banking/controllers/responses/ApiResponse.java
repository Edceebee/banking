package com.banking.banking.controllers.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private String message;
    private boolean isSuccessful;
    private LocalDateTime timeStamp;

    public ApiResponse(String message, boolean isSuccessful){
        this.message = message;
        this.isSuccessful = isSuccessful;
        timeStamp = LocalDateTime.now();
    }

    public ApiResponse(String message) {
        this.message = message;
    }
}
