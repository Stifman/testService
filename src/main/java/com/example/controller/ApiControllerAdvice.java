package com.example.controller;

import com.example.services.exceptions.UserNotCreatedException;
import com.example.services.exceptions.UserNotFoundException;
import com.example.services.exceptions.UserNotUpdatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found user in DataBase")
    public void notFoundError(UserNotFoundException exception) {

    }
    @ExceptionHandler(UserNotCreatedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not created user in DataBase")//?
    public void notCreatedError(UserNotCreatedException exception) {

    }

    @ExceptionHandler(UserNotUpdatedException.class)
    @ResponseStatus(value = HttpStatus.NOT_MODIFIED, reason = "Not updated user in DataBase")
    public void notUpdatedError(UserNotUpdatedException exception) {

    }
}