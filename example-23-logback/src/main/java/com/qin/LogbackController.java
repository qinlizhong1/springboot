package com.qin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
    private Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @RequestMapping("/t1")
    public String test1(){
        logger.info("传统方式 info 日志");
        logger.error("传统方式 error 日志");
        logger.debug("传统方式 debug 日志");

        return "ok";
    }
}
