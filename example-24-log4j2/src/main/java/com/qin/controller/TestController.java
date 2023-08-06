package com.qin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/t1")
    public String test(){
        log.error("error级别日志");
        log.info("info级别日志");
        log.warn("warn级别日志");

        return "ok";
    }
}
