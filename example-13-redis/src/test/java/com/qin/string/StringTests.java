package com.qin.string;

import com.qin.ExampleRedisApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest(classes  = ExampleRedisApplication.class)
public class StringTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void StringTest(){
        stringRedisTemplate.opsForValue().set("k1", "v11");
    }
}
