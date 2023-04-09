package com.qin.quartz.p2;

import com.qin.quartz.p1.HiJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

//一个调度器scheduler可以调度多个触发器trigger， 一个任务详情job可以被多个触发器trigger调度
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
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(10)
                                .repeatForever())
                .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("triggerHi2", "triggerGroupHi2")
                .forJob("jobHi", "groupHi")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(15)
                        .repeatForever())
                .build();

        //一个调度器scheduler可以调度多个触发器trigger
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.scheduleJob(trigger2);

        TimeUnit.SECONDS.sleep(100);

        scheduler.shutdown();
    }
}
