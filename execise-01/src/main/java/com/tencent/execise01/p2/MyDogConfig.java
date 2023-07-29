package com.tencent.execise01.p2;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@ImportResource("classpath:p2/beans.xml")
@Configuration
@PropertySource("classpath:myconfig.properties")
@ConfigurationProperties("huadog")  //被该注解作用的类必须要实现相应的setter函数，才会生效
@Setter
public class MyDogConfig {
   // @Value("${huadog.name}")
    private String name;

    //@Value("${huadog.age}")
    private Integer age;

    @Bean("greenDog")
    public Dog greenDog(){
        return new Dog("小白", 1);
                
    }
    @Bean("huaDog")
    public Dog huaDog(){
        return new Dog(name, age);

    }
}
