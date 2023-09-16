package com.qin.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduledSleepJobs {

    //测试时取消注释
    @Async("executor1")
    @Scheduled(cron = "*/5 * * * * ?")
    public void sayHelloFixedRate() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + "  hello cron1--->" + Thread.currentThread().getName());
        Thread.sleep(100000);
    }    //单位ms


    //测试时取消注释
    @Async("executor2")
    @Scheduled(cron = "*/5 * * * * ?")
    public void sayHelloFixedRateAnother() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Thread.sleep(2000);
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + "  hello cron2--->" + Thread.currentThread().getName());
    }    //单位ms
}
