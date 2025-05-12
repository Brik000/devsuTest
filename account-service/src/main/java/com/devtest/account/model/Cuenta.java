package com.devtest.account.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.math.BigDecimal;


@Entity
@Data
public class Cuenta {

    @Id
    private Long id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;

    private Long clienteId;
}
