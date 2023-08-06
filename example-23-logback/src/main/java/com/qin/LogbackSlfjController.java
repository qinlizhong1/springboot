package com.qin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogbackSlfjController {
    @RequestMapping("/t2")
    public String test1(){
        log.info("@Slf4j方式 info 日志");
        log.error("@Slf4j方式 error 日志");
        log.debug("@Slf4j方式 debug 日志");

        return "ok";
    }
}
