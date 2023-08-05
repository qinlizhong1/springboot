package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleConfigApplication.class, args);
        System.out.println("-----------------  启动完毕  -----------------");
    }

}
