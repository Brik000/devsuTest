package com.devtest.customer.controller.interfaces;


import com.devtest.customer.service.dto.ReporteResponseDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public interface IReporteController {

    @GetMapping
    ResponseEntity<ReporteResponseDTO> generarReporte(
            @RequestParam("clienteId") Long clienteId,
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin
    );
    @GetMapping("/descargar")
    ResponseEntity<ReporteResponseDTO> descargarReporte(
            @RequestParam("clienteId") Long clienteId);

}
