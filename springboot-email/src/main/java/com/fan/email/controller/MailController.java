package com.fan.email.controller;

import com.fan.email.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/send")
    public String send() {
        sendMailService.sendEmail();
        return "Send successfully!";
    }

    @GetMapping("/sendComplex")
    public String sendComplex() throws MessagingException {
        sendMailService.sendMimeEmail();
        return "Send successfully!";
    }
}
