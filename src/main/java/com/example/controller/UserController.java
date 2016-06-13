package com.example.controller; /**
 * Created by степан on 10.06.2016.
 */

import com.example.dao.ProductDao;
import com.example.dao.UserDAO;
import com.example.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllClients(){
        return userDAO.getAllUsers();
    }

}