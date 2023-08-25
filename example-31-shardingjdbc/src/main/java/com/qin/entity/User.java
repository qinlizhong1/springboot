package com.qin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//实体类一定要实现对应属性的getter方法
@AllArgsConstructor
@ToString
@Getter
public class User {
    private Integer id;
    private String fullName;
    private Integer age;
}
