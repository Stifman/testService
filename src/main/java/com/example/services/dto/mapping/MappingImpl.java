package com.example.services.dto.mapping;

import com.example.data.Role;
import com.example.data.User;
import com.example.services.dto.UserDto;

public class MappingImpl implements Mapping{

    @Override
    public UserDto fromEntityToDto(User user) {
        UserDto userDto = UserDto.newBuilder().withId(user.getId())
                .withName(user.getName())
                .withSecondname(user.getSecondname())
                .withEmail(user.getEmail())
                .withRole(user.getRole().getRole()).build();

        return userDto;
    }

    @Override
    public User fromDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSecondname(userDto.getSecondname());
        user.setEmail(userDto.getEmail());

        Role role = new Role();
        role.setRole(userDto.getRole());
        user.setRole(role);

        return user;
    }
}
