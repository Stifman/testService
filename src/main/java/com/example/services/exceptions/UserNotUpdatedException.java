package com.example.services.exceptions;


public class UserNotUpdatedException extends RuntimeException
{
    public UserNotUpdatedException(){}

    public UserNotUpdatedException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 100L;
}