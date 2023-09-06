package com.qin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisStringUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * set key value
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get key
     */
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
