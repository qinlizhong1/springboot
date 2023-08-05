package com.qin.controller;

import com.qin.entity.User;
import com.qin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/t1")
    public List<User> test1(){
        List<User> userList = userService.findAll();
        System.out.println("------------ooooooooo------");
        return userList;
    }
}
