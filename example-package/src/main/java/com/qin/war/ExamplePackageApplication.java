package com.qin.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExamplePackageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ExamplePackageApplication.class, args);
        System.out.println("-------------------------  启动完毕 -------------------------");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExamplePackageApplication.class);
    }

}
