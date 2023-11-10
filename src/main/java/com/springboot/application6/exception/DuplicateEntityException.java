package com.springboot.application6.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateEntityException extends RuntimeException{

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause ) {
        super(message, cause);
    }
}
