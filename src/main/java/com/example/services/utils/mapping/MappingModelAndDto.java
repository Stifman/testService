package com.example.services.utils.mapping;

import com.example.repository.model.User;
import com.example.services.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class MappingModelAndDto {

    public UserDto fromEntityToDto(User user) {
        UserDto userDto = UserDto.newBuilder().withId(user.getId())
                .withName(user.getName())
                .withSecondname(user.getSecondName())
                .withEmail(user.getEmail())
                .withRole(user.getRole()).build();

        return userDto;
    }

    public User fromDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSecondName(userDto.getSecondname());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());

        return user;
    }
}
