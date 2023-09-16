package com.qin.mapper;

import com.qin.entity.User;

import java.util.List;

public interface UserMapper {
    User findById(Integer id);

    User findByNameAndId(String username, Integer id);

}
