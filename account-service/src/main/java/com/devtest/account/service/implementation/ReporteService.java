package com.devtest.account.service.implementation;

import com.devtest.account.model.Cuenta;
import com.devtest.account.model.Movimiento;
import com.devtest.account.repository.CuentaRepository;
import com.devtest.account.repository.MovimientoRepository;
import com.devtest.account.service.dto.CuentaConMovimientosDTO;
import com.devtest.account.service.dto.MovimientoDTO;
import com.devtest.account.service.dto.ReporteRequestDTO;
import com.devtest.account.service.dto.ReporteResponseDTO;
import com.devtest.account.service.interfaces.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService implements IReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public ReporteResponseDTO generarReporte(ReporteRequestDTO request) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(request.getClienteId());
        List<CuentaConMovimientosDTO> cuentasDto = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(
                    cuenta.getId(), request.getFechaInicio(), request.getFechaFin());

            List<MovimientoDTO> movimientosDto = movimientos.stream().map(m -> {
                MovimientoDTO dto = new MovimientoDTO();
                dto.setFecha(m.getFecha());
                dto.setTipoMovimiento(m.getTipoMovimiento());
                dto.setValor(m.getValor());
                dto.setSaldo(m.getSaldo());
                return dto;
            }).collect(Collectors.toList());

            CuentaConMovimientosDTO cuentaDto = new CuentaConMovimientosDTO();
            cuentaDto.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaDto.setTipoCuenta(cuenta.getTipoCuenta());
            cuentaDto.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaDto.setEstado(cuenta.getEstado());
            cuentaDto.setMovimientos(movimientosDto);

            cuentasDto.add(cuentaDto);
        }

        ReporteResponseDTO response = new ReporteResponseDTO();
        response.setClienteId(request.getClienteId());
        response.setCuentas(cuentasDto);

        return response;
    }
}

