package com.qin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
@MapperScan("com.qin.mapper")
public class ExampleMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMybatisApplication.class, args);
        System.out.println("------------------  mybatis project running  ------------------");
    }
}
