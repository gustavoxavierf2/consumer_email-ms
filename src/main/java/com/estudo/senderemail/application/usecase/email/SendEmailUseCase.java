package com.estudo.senderemail.application.usecase.email;

import com.estudo.senderemail.application.dto.UserResponse;
 
public interface SendEmailUseCase {
    void sendEmail(String to, String subject, String body);
}
 