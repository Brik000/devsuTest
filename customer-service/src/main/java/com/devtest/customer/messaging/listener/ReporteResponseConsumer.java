package com.devtest.customer.messaging.listener;

import com.devtest.customer.service.dto.ReporteResponseDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReporteResponseConsumer {

    @RabbitListener(queues = "reporte.respuesta.queue")
    public void recibirReporte(ReporteResponseDTO response) {
        System.out.println("Respuesta recibida: " + response);
        //Todo reporte
        // Aquí puedes guardar el reporte, mostrarlo, cachearlo, etc.
    }
}
