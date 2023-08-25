package com.qin.controller;

import com.qin.entity.User;
import com.qin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add")
    public void test1(){
        User user1 = new User(1, "张一", 1);
        User user2 = new User(2, "李二", 2);
        User user3 = new User(3, "王三", 3);
        User user4 = new User(4, "曾四", 4);

        userMapper.insertUser(user1);
        userMapper.insertUser(user2);
        userMapper.insertUser(user3);
        userMapper.insertUser(user4);

    }

    @RequestMapping("/query")
    public void test2(){

    }
}
