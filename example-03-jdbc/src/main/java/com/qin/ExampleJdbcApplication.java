package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleJdbcApplication.class, args);
        System.out.println("-------------------- 启动完毕 --------------------");
    }

}
