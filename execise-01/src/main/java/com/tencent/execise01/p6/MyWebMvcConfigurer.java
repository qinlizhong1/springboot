package com.tencent.execise01.p6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//一定需要加上@Configuration注解
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{
    @Autowired
    @Qualifier("loginInterceptor")
    private HandlerInterceptor loginInterceptor;

    @Autowired
    @Qualifier("checkInterceptor")
    private HandlerInterceptor checkInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(checkInterceptor)
                .addPathPatterns("/p6_1")   //要拦截哪些路径, addPathPatterns("/**")表示拦截所有请求，包括我们的静态资源
                .excludePathPatterns()      //哪些路径不拦截，如果有不需要拦截的请求，可将其请求路径设置在这里
                .order(2);                   //配置多个拦截器时，指定拦截器执行顺序

        //多拦截器，依次用 registry添加
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/p6_1")
                .excludePathPatterns()
                .order(1);
    }
}
