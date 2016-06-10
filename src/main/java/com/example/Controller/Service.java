package com.example.Controller; /**
 * Created by степан on 10.06.2016.
 */

import com.example.DAO.UserDAO;
import com.example.Data.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Service {
    UserDAO user = new UserDAO();

    @RequestMapping(value = "/users",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllClient(){
        return user.getAllUsers();
    }

}