package com.example.services;

import com.example.services.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto user);

    void deleteUser(Long id);

    UserDto editUser(UserDto user);

    List<UserDto> getAllUsers();

    UserDto findById(Long id);
}
