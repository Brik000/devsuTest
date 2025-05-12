package com.devtest.customer.messaging.sender;

import com.devtest.customer.service.dto.ReporteRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteRequestSender {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    public void enviarSolicitud(ReporteRequestDTO request) {
        rabbitTemplate.convertAndSend("reporte.solicitud.queue", request);
    }
}
