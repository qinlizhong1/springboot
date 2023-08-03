package com.qin.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateUtils {

    private static RedisTemplate<String, String> redisTemplate;

    @Autowired
    private void  setRedisTemplate(RedisTemplate<String, String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    private RedisTemplateUtils(){

    }

    public static void set(){
        redisTemplate.opsForValue().set("k1", "v1");
        redisTemplate.opsForValue().set("name", "覃");redisTemplate.opsForValue();
    }
    
}
