package com.tencent.execise01.p6;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander){
        //业务逻辑，如验证是否登录，若已经登录则放行，没有登录则拦截，不会走到controller，这里只是简单的打印一句话用来模拟业务代码执行
        System.out.println("【CheckInterceptor】preHandle 方法执行");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView  modelAndView) throws Exception{
        System.out.println("【CheckInterceptor】postHandle 方法执行");
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object hander, Exception ex){
        System.out.println("【CheckInterceptor】afterCompletion 方法执行");
    }
}
