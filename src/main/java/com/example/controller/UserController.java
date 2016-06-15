package com.example.controller;

import com.example.data.User;
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
public class UserController {

    @Autowired
    private UserService userService;

    Logger log = LogManager.getLogger(UserController.class.getName());


    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        for(int i = 0; i < 1; i++) {
            log.info("INFO***");
            log.debug("DEBAG***");
            log.error("ERROR***");
            log.fatal("FATAL***");

        }

        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> findUser(@PathVariable("id") Long id) throws SQLException {

        return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserDto user) {
        userService.addUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserDto user) {

        userService.editUser(user);//id???
        return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) throws SQLException {
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.ACCEPTED);
    }

}