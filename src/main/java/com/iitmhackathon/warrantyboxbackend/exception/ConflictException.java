package com.iitmhackathon.warrantyboxbackend.exception;

public class ConflictException extends RuntimeException{
    public ConflictException(String message) {
        super(message);
    }
}
