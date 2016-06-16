package com.example.services.utils;

import com.example.repository.model.Role;
import com.example.repository.model.User;
import com.example.services.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class MappingModelAndDto {

    public UserDto fromEntityToDto(User user) {
        UserDto userDto = UserDto.newBuilder().withId(user.getId())
                .withName(user.getName())
                .withSecondname(user.getSecondname())
                .withEmail(user.getEmail())
                .withRole(user.getRole().getRole()).build();

        return userDto;
    }

    public User fromDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSecondname(userDto.getSecondname());
        user.setEmail(userDto.getEmail());

        Role role = new Role();
        role.setId(1);
        role.setRole(userDto.getRole());
        user.setRole(role);

        return user;
    }
}
