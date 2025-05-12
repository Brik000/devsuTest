package com.devtest.account.mapper;

import com.devtest.account.model.Cuenta;
import com.devtest.account.service.dto.CuentaDTO;

public class CuentaMapper {

    public static Cuenta toEntity(CuentaDTO dto) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(dto.getId());
        cuenta.setNumeroCuenta(dto.getNumeroCuenta());
        cuenta.setTipoCuenta(dto.getTipoCuenta());
        cuenta.setSaldoInicial(dto.getSaldoInicial());
        cuenta.setEstado(dto.getEstado());
        cuenta.setClienteId(dto.getClienteId());
        return cuenta;
    }
}
