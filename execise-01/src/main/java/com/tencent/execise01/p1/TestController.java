package com.tencent.execise01.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    @Qualifier("whiteDog") //系统中多个dog对象，需要使用Qualifier注解指定名称，否则会报错
    private Dog dog1;

    @Autowired
    @Qualifier("blackDog")
    private Dog dog2;

    @RequestMapping("p1_1")
    public List<Dog> test(){
        System.out.println(dog1);
        System.out.println(dog2);
        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog1);
        dogList.add(dog2);
        return dogList;
    }
}
