package com.estudo.senderemail.application.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerConfig {
    public static final String EXCHANGE_NAME = "user.events";
    public static final String QUEUE_NAME = "user.created.email";
    public static final String ROUTING_KEY = "user.created";

    @Bean
    public TopicExchange userEventsExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue userCreatedEmailQueue() {
        return new Queue(QUEUE_NAME, true); // durable = true
    }

    @Bean
    public Binding userCreatedBinding(Queue userCreatedEmailQueue, TopicExchange userEventsExchange) {
        return BindingBuilder
                .bind(userCreatedEmailQueue)
                .to(userEventsExchange)
                .with(ROUTING_KEY);
    }

}
