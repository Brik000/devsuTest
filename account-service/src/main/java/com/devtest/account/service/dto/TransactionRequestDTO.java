package com.devtest.account.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequestDTO {
    private Long cuentaId;
    private BigDecimal valor;
    private String tipoMovimiento;
}
