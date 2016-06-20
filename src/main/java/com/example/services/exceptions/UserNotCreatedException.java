package com.example.services.exceptions;

public class UserNotCreatedException extends RuntimeException{
    public UserNotCreatedException(){}

    public UserNotCreatedException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 100L;
}
