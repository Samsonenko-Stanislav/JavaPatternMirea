package com.example.Task17.services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {
    public static final String EMAIL = "samsonenko2002@yandex.ru";
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotification(Object o) throws MailException {
        System.out.println("Preparation to send email...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(EMAIL);
        mail.setFrom(EMAIL);
        mail.setSubject("Save new " + o.getClass().getSimpleName() + " at " +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .format(LocalDateTime.now()));
        mail.setText(o.toString());

        javaMailSender.send(mail);

        System.out.println("Email Send!");

    }


}