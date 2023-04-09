package com.qin.quartz.p5;

import com.qin.quartz.tools.TimeUtil;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.StringJoiner;

public class AcceptParamJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        Object v1 = jobDetail.getJobDataMap().get("jobDetail_k1");
        Object v2 = jobDetail.getJobDataMap().get("k2");

        StringJoiner stringJoiner = new StringJoiner(" ")
                .add(jobExecutionContext.getTrigger().getKey().getName())
                .add(Thread.currentThread().getName())
                .add("execute  HiJob")
                .add(TimeUtil.formatDate(new Date()));

        System.out.println(stringJoiner.toString());
        System.out.println(v1 + " " + v2);


        System.out.println(jobExecutionContext.getTrigger().getJobDataMap().get("trigger_k1") + " " + jobExecutionContext.getTrigger().getJobDataMap().get("k2"));
        System.out.println("detai和trigger相同key:" + jobExecutionContext.getMergedJobDataMap().get("k2"));
    }
}
