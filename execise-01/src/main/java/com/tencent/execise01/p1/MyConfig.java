package com.tencent.execise01.p1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {

    @Bean
    public Dog whiteDog(){
        return new Dog("小白", 10);
                
    }

    @Bean(value = "blackDog")
    public Dog dog(){
        return new Dog("小黑", 20);

    }
}
