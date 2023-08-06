package com.qin.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduledJobs {

    //单位ms
    @Scheduled(initialDelay = 8000, fixedRate = 3000)
    public void sayHelloFixedRate() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Thread.sleep(2000);
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + "  hello fixedRate--->" + Thread.currentThread().getName());
    }    //单位ms



    @Scheduled(fixedDelay = 3000)
    public void sayHelloFixedDelay() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Thread.sleep(2000);
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + "  hello fixedDelay--->" + Thread.currentThread().getName());
    }
}
