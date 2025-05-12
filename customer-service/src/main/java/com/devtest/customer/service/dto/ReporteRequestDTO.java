package com.devtest.customer.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReporteRequestDTO implements Serializable {
    private Long clienteId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
