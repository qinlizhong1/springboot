package com.qin.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

//实体类一定要实现对应属性的getter方法
@ToString
@Getter
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String phone;
}
