package com.example.demo.Error;

public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException() {
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
