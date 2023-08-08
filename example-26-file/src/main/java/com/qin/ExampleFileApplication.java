package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleFileApplication.class, args);
        System.out.println("---------------- 启动完毕 ----------------       ");
    }

}
