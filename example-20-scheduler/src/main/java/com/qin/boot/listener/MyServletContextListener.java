package com.qin.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//在系统启动时，使用 Listener 监听器进行初始化和销毁操作
public class MyServletContextListener implements ServletContextListener {
    /**
     容器启动时
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化必要的数据. 常于构建缓存，初始化数据.
        System.out.println("-------  Listener, 执行初始化必要的数据等操作  ------- ");
    }

    /**
     容器销毁时
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //这个阶段进行数据备份的处理.
        System.out.println("------- Listener, 执行重要数据备份等操作  ------- ");
    }
}
