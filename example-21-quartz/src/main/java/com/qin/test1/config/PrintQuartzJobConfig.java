package com.qin.test1.config;

import com.qin.test1.jobs.PrintQuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PrintQuartzJobConfig {
    @Bean
    public JobDetail myJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(PrintQuartzJob.class)
            //
            .withIdentity("printQuartzJob","qin-jobDetail")
            //JobDataMap可以给任务execute传递参数
            //.usingJobData("name","guojing")
            //.usingJobData("age",26)
            .storeDurably()
            .build();
        return jobDetail;
    }
    @Bean
    public Trigger myTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                //设置触发器一相关属性 比如名字，组名。
                .withIdentity("printTrigger","qin-trigger")
                //.usingJobData("job_trigger_param","job_trigger_param1")
                //立刻启动
                .startNow()
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                // 固化的 cron 表达式
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
                .build();
        return trigger;
    }
}
