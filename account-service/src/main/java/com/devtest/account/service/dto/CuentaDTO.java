package com.devtest.account.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CuentaDTO {
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private Long clienteId;
}
