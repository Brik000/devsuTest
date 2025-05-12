package com.devtest.customer.service.implementation;

import com.devtest.customer.model.Reporte;
import com.devtest.customer.repository.ReporteRepository;
import com.devtest.customer.service.dto.ReporteRequestDTO;
import com.devtest.customer.service.dto.ReporteResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReporteService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReporteRepository reporteRepository;

    public ReporteResponseDTO enviarYEsperarRespuesta(ReporteRequestDTO request) {
        Object response = rabbitTemplate.convertSendAndReceive("reporte.solicitud.queue", request);
        return (ReporteResponseDTO) response;
    }

    public void saveReporte(byte[] contenido, Long clienteId) {
        reporteRepository.deleteByClienteId(clienteId);

        Reporte nuevoReporte = new Reporte();
        nuevoReporte.setClienteId(clienteId);
        nuevoReporte.setContenido(contenido);
        reporteRepository.save(nuevoReporte);
    }

    public Optional<ReporteResponseDTO> findReporteByClienteId(Long clienteId) {
        return reporteRepository.findByClienteId(clienteId)
                .map(reporte -> {
                    try {
                        return objectMapper.readValue(reporte.getContenido(), ReporteResponseDTO.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Error al deserializar el reporte del cliente " + clienteId, e);
                    }
                });
    }

}
