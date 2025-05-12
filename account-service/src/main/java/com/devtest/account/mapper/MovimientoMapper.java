package com.devtest.account.mapper;

import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.MovimientoDTO;

public class MovimientoMapper {

    public static Movimiento toEntity(MovimientoDTO dto) {
        Movimiento movimiento = new Movimiento();
        movimiento.setId(dto.getId());
        movimiento.setFecha(dto.getFecha());
        movimiento.setTipoMovimiento(dto.getTipoMovimiento());
        movimiento.setValor(dto.getValor());
        movimiento.setSaldo(dto.getSaldo());
        movimiento.setCuentaId(dto.getCuentaId());
        return movimiento;
    }
}
