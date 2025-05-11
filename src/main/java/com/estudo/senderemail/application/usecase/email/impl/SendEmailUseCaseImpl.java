package com.estudo.senderemail.application.usecase.email.impl;


import com.estudo.senderemail.application.dto.UserResponse;
import com.estudo.senderemail.application.usecase.email.SendEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;




@Service
@RequiredArgsConstructor
public class SendEmailUseCaseImpl implements SendEmailUseCase {
    private final JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String to, String subject, String body) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao enviar email", e);
        }

    }
}