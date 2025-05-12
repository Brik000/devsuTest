package com.devtest.account.service.interfaces;

import com.devtest.account.exception.AccountNotFoundException;
import com.devtest.account.exception.SaldoInsuficienteException;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;

public interface ITransactionService {

    public Movimiento procesarMovimiento(TransactionRequestDTO movimiento)throws SaldoInsuficienteException, AccountNotFoundException;
}
