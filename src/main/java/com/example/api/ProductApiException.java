package com.example.api;

public class ProductApiException extends Exception {
    public ProductApiException(String message) {
        super(message);
    }

    public ProductApiException(String message, Throwable cause) {
        super(message, cause);
    }
} 