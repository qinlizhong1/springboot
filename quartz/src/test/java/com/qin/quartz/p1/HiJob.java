package com.qin.quartz.p1;

import com.qin.quartz.tools.TimeUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.StringJoiner;

public class HiJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StringJoiner stringJoiner = new StringJoiner(" ")
                .add(jobExecutionContext.getTrigger().getKey().getName())
                .add(Thread.currentThread().getName())
                .add("execute  HiJob")
                .add(TimeUtil.formatDate(new Date()));
        System.out.println(stringJoiner.toString());
    }
}
