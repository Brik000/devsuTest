package com.devtest.account.service.implementation;

import com.devtest.account.exception.AccountNotFoundException;
import com.devtest.account.exception.SaldoInsuficienteException;
import com.devtest.account.mapper.TransactionMapper;
import com.devtest.account.model.Cuenta;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;
import com.devtest.account.service.interfaces.ICuentaService;
import com.devtest.account.service.interfaces.IMovimientoService;
import com.devtest.account.service.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private  ICuentaService cuentaService;
    @Autowired
    private  IMovimientoService movimientoService;

    @Override
    @Transactional
    public Movimiento procesarMovimiento(TransactionRequestDTO request) throws SaldoInsuficienteException,AccountNotFoundException{
        Cuenta cuenta = cuentaService.findByNumeroCuentaForUpdate(request.getCuentaNumero())
                .orElseThrow(() -> new AccountNotFoundException("Cuenta no encontrada"));

        BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(request.getValor());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaService.update(cuenta);

        Movimiento movimiento = TransactionMapper.toMovimiento(request, nuevoSaldo,cuenta.getId());

        return movimientoService.create(movimiento);
    }
}

