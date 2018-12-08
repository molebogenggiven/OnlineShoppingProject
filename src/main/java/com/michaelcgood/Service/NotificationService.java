package com.michaelcgood.Service;


import com.michaelcgood.Exceptions.User;
import com.sun.activation.registries.MailcapParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) throws MailException {

        //send email
        this.javaMailSender = javaMailSender;


    }

    public void sendNotification(User user){
        SimpleMailMessage  mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAdress());

        mail.setFrom("molebogeng.kubyana@gmail.com");
        mail.setSubject("Order from McDonald");
        mail.setText("Hi Given Please find the code below :" + generateRandomNumber());

        javaMailSender.send(mail);


    }

    public int generateRandomNumber(){

        Random random = new Random();
        int randomNumber = random.nextInt(50)*100+1;

        return randomNumber;

    }
}

