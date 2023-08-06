package com.qin.boot.config;

import com.qin.boot.listener.MyServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    //生成
    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> initListenerServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyServletContextListener> registrationBean =
                new ServletListenerRegistrationBean<>(new MyServletContextListener());
        return registrationBean;
    }
}
