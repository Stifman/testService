package com.example.services.utils.userValidator;

import com.example.services.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (UserValidatorUtil.validateUserString(userDto.getName(), 40)) {
            errors.rejectValue("name", "wrong name");
        }

        if (UserValidatorUtil.validateUserString(userDto.getSecondname(), 40)) {
            errors.rejectValue("secondname", "wrong secondname");
        }

        if (UserValidatorUtil.validateUserString(userDto.getRole(), 40)) {
            errors.rejectValue("role", "wrong role");
        }

    }
}