package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ExampleQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleQuartzApplication.class, args);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + ":---------------- 启动成功!! --------------");
    }

}
