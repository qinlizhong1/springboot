package com.qin.controller;

import com.qin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActuatorController {

    @Autowired
    private OrderService orderService;
}
