package com.qin.quartz.p4;

import com.qin.quartz.p1.HiJob;
import org.quartz.*;

import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


@SpringBootTest
public class QuartzTests {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        //任务详情
        JobDetail jobDetail = JobBuilder.newJob(HiJob.class)
                .withIdentity("jobHi", "groupHi")
                .build();

        //触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerHi", "triggerGroupHi")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("/5 * * * * ? *"))
                                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        TimeUnit.SECONDS.sleep(30);

        scheduler.shutdown();
    }
}
