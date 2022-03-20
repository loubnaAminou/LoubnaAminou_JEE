package com.example.jpainheritance.web;

import com.example.jpainheritance.entities.User;
import com.example.jpainheritance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public User user(String username){
        System.out.println(username);
        return userService.findUserByUserName(username);
    }
}
