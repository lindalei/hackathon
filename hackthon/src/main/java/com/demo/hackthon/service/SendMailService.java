package com.demo.hackthon.service;

import com.demo.hackthon.dto.MailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail1(MailInfo mailInfo) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailInfo.getSenderEmail());
        message.setTo(mailInfo.getReceiverEmails());
        message.setSubject(mailInfo.getSubject());
        message.setText(mailInfo.getContent());
        mailSender.send(message);
    }

    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1019362617@qq.com");
        message.setTo("1019362617@qq.com");
        message.setSubject("报名信息");
        message.setText("报名内容");
        mailSender.send(message);
    }
}
