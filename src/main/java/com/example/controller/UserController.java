package com.example.controller;

import com.example.repository.model.User;
import com.example.services.UserService;
import com.example.services.dto.UserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping(value = "/api/users", produces= MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    public static final Logger log = LogManager.getLogger(UserController.class.getName());


    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAllUsers() {
        for(int i = 0; i < 1; i++) {
            log.info("INFO***");
            log.debug("DEBAG***");
            log.error("ERROR***");
            log.fatal("FATAL***");

        }

        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<UserDto> findUser(@PathVariable("id") Long id) throws SQLException {

        return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserDto user) {
        userService.addUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserDto user) {

        userService.editUser(user);//id???
        return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) throws SQLException {
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }

}