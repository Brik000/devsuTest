package com.devtest.customer.service.implementation;

import com.devtest.customer.exception.ClienteNoExisteException;
import com.devtest.customer.exception.RangoFechasInvalidoException;
import com.devtest.customer.messaging.listener.ReporteResponseConsumer;
import com.devtest.customer.messaging.sender.ReporteRequestSender;
import com.devtest.customer.model.Cliente;
import com.devtest.customer.model.Reporte;
import com.devtest.customer.repository.ClienteRepository;
import com.devtest.customer.repository.ReporteRepository;
import com.devtest.customer.service.dto.ReporteRequestDTO;
import com.devtest.customer.service.dto.ReporteResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReporteService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReporteRequestSender reporteRequestSender;


    public void enviarRespuesta(ReporteRequestDTO request) throws ClienteNoExisteException,RangoFechasInvalidoException{
        if (!clienteRepository.existsById(request.getClienteId())) {
            throw new ClienteNoExisteException("El cliente con ID " + request.getClienteId() + " no existe.");
        }

        LocalDate inicio = request.getFechaInicio();
        LocalDate fin = request.getFechaFin();

        if (inicio.isAfter(fin)) {
            throw new RangoFechasInvalidoException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        reporteRequestSender.enviarSolicitud(request);
    }
    @Transactional
    public void saveReporte(byte[] contenido, Long clienteId) {
        reporteRepository.deleteByClienteId(clienteId);

        Reporte nuevoReporte = new Reporte();
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));

        nuevoReporte.setCliente(cliente);
        nuevoReporte.setContenido(contenido);

        reporteRepository.save(nuevoReporte);
    }

    @Transactional
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
