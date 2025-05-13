package com.devtest.customer.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
class CuentaConMovimientosDTO implements Serializable {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private List<MovimientoDTO> movimientos;
}
