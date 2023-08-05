package com.qin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${k1}")
    private String k1;

    @Value("${k2}")
    private String k2;

    @Value("${k3}")
    private String k3;

    @RequestMapping("/t1")
    public String test1(){
        System.out.println("k1--->" + k1);
        System.out.println("k2--->" + k2);
        System.out.println("k3--->" + k3);
        return "ok";
    }
}
