package com.hltx.pay.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

/**
 * User: ycj
 * Date: 2020/8/10
 * Time: 18:18
 * Description:
 */
public class SendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String from,String to,String title,String context) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(context);
        javaMailSender.send(message);
    }
}
