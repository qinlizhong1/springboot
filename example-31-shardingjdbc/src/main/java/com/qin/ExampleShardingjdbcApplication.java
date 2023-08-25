package com.qin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qin.mapper")
public class ExampleShardingjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleShardingjdbcApplication.class, args);
        System.out.println("--------------------  启动完毕  -----------------");
    }

}
