package com.qin.test1.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//创建定时任务类， 继承 QuartzJobBean
public class PrintQuartzJob extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=simpleDateFormat.format(new Date());
        System.out.println(" 【PrintQuartzJob】: " + now + " : " + Thread.currentThread().getName() + "------>执行定时任务~~" );
        System.out.println(context.getJobDetail().getKey());
       // System.out.println(context.getTrigger().getKey());
        System.out.println();
    }
}
