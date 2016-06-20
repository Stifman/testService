package com.example.services.exceptions;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(){}

    public UserNotFoundException(String message) {
        super(message);
    }

    private static final long serialVersionUID = 100L;
}