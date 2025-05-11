package com.estudo.senderemail.application.facede;


import com.estudo.senderemail.application.dto.UserResponse;
import com.estudo.senderemail.application.usecase.email.SendEmailUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailFacade {
    
    private final SendEmailUseCase sendEmailUseCase;


    public void sendEmail(String to, String subject, String body) {
        sendEmailUseCase.sendEmail(to, subject, body);
    }

} 