package com.estudo.senderemail.infrastructure.messaging;


import com.estudo.senderemail.application.config.RabbitMQConsumerConfig;
import com.estudo.senderemail.application.dto.UserResponse;
import com.estudo.senderemail.application.facede.SendEmailFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreatedConsumer {

    private final SendEmailFacade sendEmailFacade;

    @RabbitListener(queues = RabbitMQConsumerConfig.QUEUE_NAME)
    public void handleUserCreated(UserResponse event) {
        try {
            log.info("Received user created event for user: {}", event.getEmail());
            sendEmailFacade.sendEmail(event.getEmail(), "teste", event.getName() + "testests");
            log.info("Welcome email sent successfully to: {}", event.getEmail());
        } catch (Exception e) {
            log.error("Error processing user created event for user: {}", event.getEmail(), e);
            throw e;
        }
    }
}