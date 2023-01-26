package com.example.orderservice.exeption;

import org.springframework.http.HttpStatus;

public class NotAllMatchException extends RuntimeException{
    private final HttpStatus status;

    public NotAllMatchException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

