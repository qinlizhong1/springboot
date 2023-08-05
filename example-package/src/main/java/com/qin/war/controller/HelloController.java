package com.qin.war.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/t1")
    public String test1(){
        System.out.println("hello, springBoot~~~");
        return "hello, springBoot~~~";
    }
}
