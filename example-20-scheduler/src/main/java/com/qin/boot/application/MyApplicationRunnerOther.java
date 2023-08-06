package com.qin.boot.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//注解将 MyCommandLineRunner注册为Spring容器中的一个 Bean。
@Component

//表示这个启动任务的执行优先级，在一个项目中，启动任务可能有多个，所以需要有一个排序。数字越小，优先级越大，
@Order(1)
public class MyApplicationRunnerOther implements ApplicationRunner {
    //在 run 方法中，写启动任务的核心逻辑，当项目启动时，run方法会被自动执行
    //args参数是启动类传递过来的
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--------------  我是ApplicationRunner方式的启动任务 优先级1  ---------------");
    }
}