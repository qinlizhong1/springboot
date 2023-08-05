package com.tencent.execise01;

import com.tencent.execise01.p2.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Execise01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Execise01Application.class, args);

        String[] beanNamesForTypes = context.getBeanNamesForType(Dog.class);
        for (String beanNamesForType:beanNamesForTypes) {
            System.out.println("==============>"+beanNamesForType);
            System.out.println(context.getBean(beanNamesForType));
        }


    }

}
