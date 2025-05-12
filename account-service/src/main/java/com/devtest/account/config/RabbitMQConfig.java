package com.devtest.account.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue solicitudQueue() {
        return new Queue("reporte.solicitud.queue");
    }

    @Bean
    public Queue respuestaQueue() {
        return new Queue("reporte.respuesta.queue");
    }
}