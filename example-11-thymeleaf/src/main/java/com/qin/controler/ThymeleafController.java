package com.qin.controler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @RequestMapping("/t1")
    public String test(Model model){
        model.addAttribute("title","整合Thymeleaf");
        model.addAttribute("name","郭靖");
        return "test";
    }

    @RequestMapping("/t2")
    public String test2(Model model){

        return "hello";
    }
}
