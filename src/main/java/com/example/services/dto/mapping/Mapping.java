package com.example.services.dto.mapping;

import com.example.data.User;
import com.example.services.dto.UserDto;

public interface Mapping {
    UserDto fromEntityToDto(User user);
    User fromDtoToEntity(UserDto userDto);

}
