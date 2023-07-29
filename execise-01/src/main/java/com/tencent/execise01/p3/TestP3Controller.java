package com.tencent.execise01.p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestP3Controller {
    @Autowired()
    @Qualifier("c1")
    private Cat cat1;

    @Autowired()
    @Qualifier("c2")
    private Cat cat2;


    @Autowired()
    @Qualifier("d1")
    private Dog dog;

    @RequestMapping("p3_1")
    public List<Cat> test1(){
        List<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);

        return catList;
    }

    @RequestMapping("p3_2")
    public Dog test2(){
        return dog;
    }
}
