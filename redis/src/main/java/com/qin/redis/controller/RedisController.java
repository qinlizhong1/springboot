package com.qin.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private RedisTemplate redisTemplate;

    @RequestMapping("/set")
    public String set(){

        return "ok";
    }
}
