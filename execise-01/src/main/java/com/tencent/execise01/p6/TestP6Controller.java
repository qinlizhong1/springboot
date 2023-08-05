package com.tencent.execise01.p6;

import com.tencent.execise01.p3.Cat;
import com.tencent.execise01.p3.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestP6Controller {
    @RequestMapping("p6_1")
    public String test1() {
        System.out.println("控制器方法执行");
        return "ok";
    }
}
