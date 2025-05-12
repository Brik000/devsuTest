package com.devtest.account.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CuentaConMovimientosDTO implements Serializable {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private List<MovimientoDTO> movimientos;
}
