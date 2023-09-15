package com.qin.controller;

import com.qin.entity.MailRequest;
import com.qin.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class SendMailController {
    @Autowired
    private SendMailService sendMailService;

    //简单邮件
    @RequestMapping("/simple")
    public void SendSimpleMessage() {

        MailRequest mailRequest = new MailRequest();
        mailRequest.setSendTo("1@163.com");
        mailRequest.setSubject("丐帮大会");
        mailRequest.setText("郭大侠，您好，请于十月12号参加丐帮大会");

        sendMailService.sendSimpleMail(mailRequest);
    }

    @RequestMapping("/html")
    public void SendHtmlMessage() {
        MailRequest mailRequest = new MailRequest();

        mailRequest.setSendTo("2@163.com");
        mailRequest.setSubject("软件大会");
        mailRequest.setText("张老师，您好，请于十月12号参加软件大会");
        mailRequest.setFilePath("/Users/qin/test.txt");

        sendMailService.sendHtmlMail(mailRequest);
    }
}

