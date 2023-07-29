package com.tencent.execise01.p3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
//@AllArgsConstructor @AllArgsConstructor与@Value注解不能同时使用，否则启动报错
@Component("d1")
@PropertySource("classpath:p3/catconfig.properties")
public class Dog {


    @Value("${d1.name}")
    private String name;
    @Value("${d1.age}")
    private Integer age;
}
