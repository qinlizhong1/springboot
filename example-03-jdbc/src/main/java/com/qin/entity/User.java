package com.qin.entity;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;


@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String phone;
}
