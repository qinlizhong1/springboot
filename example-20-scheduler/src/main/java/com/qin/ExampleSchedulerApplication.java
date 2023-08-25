package com.qin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

//cron表达式在线生成器：  https://cron.qqe2.com/
@EnableScheduling
@SpringBootApplication
public class ExampleSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSchedulerApplication.class, args);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + ":---------------- 启动成功!! --------------");
    }
}


