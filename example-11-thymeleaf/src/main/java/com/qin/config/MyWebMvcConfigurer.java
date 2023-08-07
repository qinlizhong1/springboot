package com.qin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")//添加静态资源所在目录
                .addResourceLocations("classpath:resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");//可以添加多个
    }
}
