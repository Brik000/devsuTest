package com.devtest.customer.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReporteResponseDTO implements Serializable {
    private Long clienteId;
    private List<CuentaConMovimientosDTO> cuentas;
}
