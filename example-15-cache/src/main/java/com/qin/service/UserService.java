package com.qin.service;

import com.qin.entity.User;
import com.qin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    // value 表示使用的缓存组， key 表示缓存的值。
    // value::id 组成缓存的key
    @Cacheable(value="user",key = "#id")
    public User findById(Integer id){
        return userMapper.findById(id);
    }

    @Cacheable(cacheNames="user", key = "#username + #id", condition ="#id<3")
    public User findByNameAndId(String username, Integer id){
        return userMapper.findByNameAndId(username, id);
    }
}
