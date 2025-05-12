package com.devtest.account.messaging.producer;


import com.devtest.account.service.dto.ReporteRequestDTO;
import com.devtest.account.service.dto.ReporteResponseDTO;
import com.devtest.account.service.implementation.ReporteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReporteRequestConsumer {

    @Autowired
    private  ReporteService reporteService;
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "reporte.solicitud.queue")
    public void procesarSolicitud(ReporteRequestDTO request) {
        ReporteResponseDTO response = reporteService.generarReporte(request);
        rabbitTemplate.convertAndSend("reporte.respuesta.queue", response);
    }
}
