package com.tencent.execise01.p3;

import com.tencent.execise01.p2.Dog;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:p3/catconfig.properties")
@PropertySource("classpath:p3/catconfig.yml")
public class MyCatConfig {
    @Value("${c1.name}")
    private String c1Name;
    @Value("${c1.age}")
    private Integer c1Age;

    @Value("${c2.name}")
    private String c2Name;
    @Value("${c2.age}")
    private Integer c2Age;


    @Bean("c1")
    public Cat Cat1(){
        return new Cat(c1Name, c1Age);
                
    }

    @Bean("c2")
    public Cat Cat2(){
        return new Cat(c2Name, c2Age);

    }
}
