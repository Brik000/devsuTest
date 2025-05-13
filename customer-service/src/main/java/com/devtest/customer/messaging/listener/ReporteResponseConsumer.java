package com.devtest.customer.messaging.listener;

import com.devtest.customer.service.dto.ReporteResponseDTO;
import com.devtest.customer.service.implementation.ReporteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;


@Component
public class ReporteResponseConsumer {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "reporte.respuesta.queue")
    public void recibirReporte(ReporteResponseDTO response) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            objectMapper.writeValue(out, response);
            byte[] reporteBytes = out.toByteArray();

            reporteService.saveReporte(reporteBytes, response.getClienteId());
            System.out.println("Reporte guardado exitosamente para clienteId: " + response.getClienteId());

        } catch (Exception e) {
            System.err.println("Error procesando el reporte recibido: " + e.getMessage());
        }
    }
}
