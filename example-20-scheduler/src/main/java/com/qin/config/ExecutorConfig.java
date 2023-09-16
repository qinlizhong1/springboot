package com.qin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//自定义线程池执行定时任务

@Configuration
@EnableAsync
public class ExecutorConfig {
    @Bean
    public Executor executor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("qin-schedule-");
        executor.setMaxPoolSize(20);
        executor.setCorePoolSize(15);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Bean
    public Executor executor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("zhang-schedule-");
        executor.setMaxPoolSize(20);
        executor.setCorePoolSize(15);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
