package com.qin.quartz.p5;

import com.qin.quartz.p1.HiJob;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


@SpringBootTest
public class QuartzTests {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(AcceptParamJob.class)
                .withIdentity("paramJob", "paramJobGroup")
                .usingJobData("jobDetail_k1", "jobDetail_v1") //通过usingJobData传参
                .usingJobData("k2", 1)    //
                .build();

        Trigger trigger =TriggerBuilder.newTrigger()
                .withIdentity("paramJobTrigger", "paramJobGroupTrigger")
                .usingJobData("trigger_k1", "trigger_v1") //Trigger也可以通过usingJobData传参
                .usingJobData("k2", 2)    //
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ? *"))
                .build();


        scheduler.scheduleJob(jobDetail, trigger);

        TimeUnit.SECONDS.sleep(30);

        scheduler.shutdown();

    }
}
