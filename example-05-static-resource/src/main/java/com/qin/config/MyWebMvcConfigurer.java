package com.qin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//测试配置文件方式注册静态资源路径，需关闭这种方式
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/mystatic/")//添加静态资源所在目录
                .addResourceLocations("classpath:/mypublic/");//可以添加多个
    }
}
