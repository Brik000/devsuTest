package com.devtest.account.mapper;

import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionMapper {

    public static Movimiento toMovimiento(TransactionRequestDTO dto, BigDecimal nuevoSaldo,Long cuentaId) {
        Movimiento movimiento = new Movimiento();
        movimiento.setCuentaId(cuentaId);
        movimiento.setTipoMovimiento(dto.getTipoMovimiento());
        movimiento.setValor(dto.getValor());
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDate.now());
        return movimiento;
    }
}
