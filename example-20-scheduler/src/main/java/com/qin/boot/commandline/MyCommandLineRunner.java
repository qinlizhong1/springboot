package com.qin.boot.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//注解将 MyCommandLineRunner注册为Spring容器中的一个 Bean。
@Component

//表示这个启动任务的执行优先级，在一个项目中，启动任务可能有多个，所以需要有一个排序。数字越小，优先级越大，
@Order(10)
public class MyCommandLineRunner implements CommandLineRunner {
    //在 run 方法中，写启动任务的核心逻辑，当项目启动时，run方法会被自动执行
    //args参数是启动类传递过来的
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------  我是CommandLineRunner方式的启动任务 优先级10  ---------------");
    }
}