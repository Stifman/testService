package com.example.services.impl;

import com.example.repository.UserRepository;
import com.example.repository.model.User;
import com.example.services.UserService;
import com.example.services.dto.UserDto;
import com.example.services.utils.MappingModelAndDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Logger log = LogManager.getLogger(UserServiceImpl.class.getName());
    private MappingModelAndDto mapping = new MappingModelAndDto();

    @Override
    @Transactional
    public UserDto addUser(UserDto user) {
        User savedUser = userRepository.save(mapping.fromDtoToEntity(user));

        return mapping.fromEntityToDto(savedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public UserDto editUser(UserDto user) {
        mapping.fromDtoToEntity(user);
        return mapping.fromEntityToDto(userRepository.save(mapping.fromDtoToEntity(user)));
    }

    @Override
    @Transactional
    public List<UserDto> getAllUsers() {


        for (int i = 0; i < 1; i++) {

            log.info("INFO***Service");
            log.debug("DEBAG***Service");
            log.error("ERROR***Service");
            log.fatal("FATAL***Service");

        }

        List<User> users = (List<User>) userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<UserDto>();

        for (User user : users
                ) {
            userDtos.add(mapping.fromEntityToDto(user));
        }
        //users.stream().map(user -> userDtos.add(mapping.fromEntityToDto(user)));

        return userDtos;
    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        return mapping.fromEntityToDto(userRepository.findOne(id));
    }
}
