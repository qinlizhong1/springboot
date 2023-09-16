package com.qin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.qin.mapper")
@EnableCaching
@SpringBootApplication
public class ExampleCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleCacheApplication.class, args);
    }
}
