package com.qin;

import com.qin.entity.User;
import com.qin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class Example15CacheApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void findByIdTest(){
        User user1 = userService.findById(10);
        System.out.println("-------------- 分隔符 --------------");
        User user2 = userService.findById(10);
    }

    @Test
    public void findByNameAndIdTest(){
        User user1 = userService.findByNameAndId("tom", 3);
        System.out.println("-------------- 分隔符 --------------");
        User user2 = userService.findByNameAndId("tom", 3);
    }
}
