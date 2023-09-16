package com.qin.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduledCronJobs {

    //测试时取消注释
    //@Scheduled(cron = "*/5 * * * * ?")
    public void sayHelloFixedRate() throws InterruptedException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Thread.sleep(2000);
        String now=simpleDateFormat.format(new Date());
        System.out.println(now + "  hello cron--->" + Thread.currentThread().getName());
    }    //单位ms
}
