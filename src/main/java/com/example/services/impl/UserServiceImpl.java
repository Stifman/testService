package com.example.services.impl;

import com.example.repository.UserRepository;
import com.example.repository.model.User;
import com.example.services.UserService;
import com.example.services.dto.UserDto;
import com.example.services.exceptions.UserNotCreatedException;
import com.example.services.exceptions.UserNotFoundException;
import com.example.services.exceptions.UserNotUpdatedException;
import com.example.services.utils.mapping.MappingModelAndDto;
import com.example.services.utils.userValidator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private static final MappingModelAndDto mapping = new MappingModelAndDto();

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {


        DataBinder binder = new DataBinder(userDto);
        binder.setValidator(new UserValidator());
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();
        if (bindingResult.hasErrors()) {
            LOGGER.error("in addUser cant add User " + bindingResult.getFieldError());
            throw new UserNotCreatedException();
        }
        User savedUser = userRepository.save(mapping.fromDtoToEntity(userDto));
        return mapping.fromEntityToDto(savedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        try {
            userRepository.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            LOGGER.error("Not Fount User in Data Base with id = " + id);
            throw new UserNotFoundException("Not found user with id = " + id);
        }
    }

    @Override
    @Transactional
    public UserDto editUser(Long id, UserDto userDto) {

        if (userRepository.findOne(id) == null) {
            LOGGER.log(Level.ERROR, "Not Fount User in Data Base with id =" + id);
            throw new UserNotFoundException("User not found in Data Base!!!");
        }
        DataBinder binder = new DataBinder(userDto);
        binder.setValidator(new UserValidator());
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();
        if (bindingResult.hasErrors()) {
            LOGGER.error("in editUser cant edit User " + bindingResult.getFieldError());
            throw new UserNotUpdatedException();
        }
        User user = mapping.fromDtoToEntity(userDto);
        user.setId(id);
        return mapping.fromEntityToDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public List<UserDto> getAllUsers() {
        List<UserDto> users;
        Iterable<User> userIterable = userRepository.findAll();
        users = StreamSupport.stream(userIterable.spliterator(), Boolean.FALSE)
                .map(
                        user -> mapping.fromEntityToDto(user)
                )
                .collect(Collectors.toList());

        if (users.isEmpty()) {
            LOGGER.log(Level.ERROR, "Not Fount Users in Data Base");
            throw new UserNotFoundException("Users not found in Data Base");
        }
        return users;

    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            LOGGER.log(Level.ERROR, "Not Fount User in Data Base with id =" + id);
            throw new UserNotFoundException("User not found in Data Base!!!");
        }
        return mapping.fromEntityToDto(user);
    }
}
