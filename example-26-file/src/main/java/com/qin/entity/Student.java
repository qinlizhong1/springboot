package com.qin.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Alias("stuId")
    private Integer id;
    @Alias("stuName")
    private String name;
    @Alias("stuSex")
    private String sex;
}
