package com.fan.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailService {


    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendEmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("~露出想你的小马脚~");
        mailMessage.setText("晚上 eat what?");

        mailMessage.setTo("664906593@qq.com");
        mailMessage.setFrom("664906593@qq.com");

        mailSender.send(mailMessage);
    }

    public void sendMimeEmail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("Your Kitty and Puppy");
        helper.setText("<h1 style='color :red’>喵咪咪, 喵咪咪</h1>", true);

        helper.addAttachment("cat.jpg", new File("C:\\Users\\yahfan\\Desktop\\cat.jpg"));
        helper.addAttachment("dog.jpg", new File("C:\\Users\\yahfan\\Desktop\\dog.jpg"));

        helper.setTo("664906593@qq.com");
        helper.setFrom("664906593@qq.com");

        mailSender.send(mimeMessage);
    }
}
