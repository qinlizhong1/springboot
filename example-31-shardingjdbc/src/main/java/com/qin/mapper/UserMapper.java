package com.qin.mapper;

import com.qin.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public Integer insertUser(User user);
    public List<User> findAll();
}
