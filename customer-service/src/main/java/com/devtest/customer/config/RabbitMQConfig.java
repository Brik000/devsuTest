package com.devtest.customer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue solicitudQueue() {
        return new Queue("reporte.solicitud.queue");
    }

    @Bean
    public Queue reporteRespuestaQueue() {
        return new Queue("reporte.respuesta.queue", true);
    }
}
