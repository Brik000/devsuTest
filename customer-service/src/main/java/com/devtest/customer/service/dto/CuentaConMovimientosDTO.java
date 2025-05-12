package com.devtest.customer.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
class CuentaConMovimientosDTO implements Serializable {
    private Long cuentaId;
    private String tipoCuenta;
    private BigDecimal saldo;
    private List<MovimientoDTO> movimientos;
}
