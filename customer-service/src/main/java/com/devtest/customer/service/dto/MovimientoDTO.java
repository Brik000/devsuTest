package com.devtest.customer.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
class MovimientoDTO implements Serializable {
    private LocalDate fecha;
    private String tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
}
