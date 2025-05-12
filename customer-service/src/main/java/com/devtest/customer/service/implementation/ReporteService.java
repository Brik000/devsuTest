package com.devtest.customer.service.implementation;

import com.devtest.customer.service.dto.ReporteRequestDTO;
import com.devtest.customer.service.dto.ReporteResponseDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ReporteResponseDTO enviarYEsperarRespuesta(ReporteRequestDTO request) {
        Object response = rabbitTemplate.convertSendAndReceive("reporte.solicitud.queue", request);
        return (ReporteResponseDTO) response;
    }
}
