package com.tencent.execise01.p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestP2Controller {
    @Autowired
    @Qualifier("greenDog") //系统中多个dog对象，需要使用Qualifier注解指定名称，否则会报错
    private Dog dog1;

    @Autowired
    @Qualifier("smallDog")
    private Dog dog2;

    @Autowired
    @Qualifier("huaDog")
    private Dog dog3;

    @RequestMapping("p2_1")
    public List<Dog> test(){
        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        return dogList;
    }
}
