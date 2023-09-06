package com.qin.string;

import com.qin.ExampleRedisApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest(classes  = ExampleRedisApplication.class)
public class StringTests {
    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void StringTest(){
        redisTemplate.opsForValue().set("k2", "中国w");
    }
}
