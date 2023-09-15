package com.qin.mapper;

import com.qin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserMapper {
    //void addUser(User user);
    List<User> findAll();
    //void deleteUser(Integer id);
}
