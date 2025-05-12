package com.devtest.customer.controller.implementation;

import com.devtest.customer.controller.interfaces.IReporteController;


import com.devtest.customer.service.dto.ReporteRequestDTO;
import com.devtest.customer.service.dto.ReporteResponseDTO;
import com.devtest.customer.service.implementation.ReporteService;
import com.devtest.customer.service.interfaces.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reportes")
public class ReporteController implements IReporteController {

    @Autowired
    private ReporteService reporteService;

    @Override
    @GetMapping
    public ResponseEntity<ReporteResponseDTO> generarReporte(
            @RequestParam("clienteId") Long clienteId,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        ReporteRequestDTO request = new ReporteRequestDTO();
        request.setClienteId(clienteId);
        request.setFechaInicio(fechaInicio);
        request.setFechaFin(fechaFin);

        ReporteResponseDTO response = reporteService.enviarYEsperarRespuesta(request);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/descargar")
    public ResponseEntity<ReporteResponseDTO> descargarReporte(
            @RequestParam("clienteId") Long clienteId) {

        return reporteService.findReporteByClienteId(clienteId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
