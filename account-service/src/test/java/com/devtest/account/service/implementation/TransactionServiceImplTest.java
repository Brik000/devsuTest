package com.devtest.account.service.implementation;

import com.devtest.account.exception.AccountNotFoundException;
import com.devtest.account.exception.SaldoInsuficienteException;
import com.devtest.account.model.Cuenta;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;
import com.devtest.account.service.interfaces.ICuentaService;
import com.devtest.account.service.interfaces.IMovimientoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransactionServiceImplTest {

    @Mock
    private ICuentaService cuentaService;

    @Mock
    private IMovimientoService movimientoService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void procesarMovimiento_exito() throws Exception {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setCuentaNumero(123L);
        request.setValor(BigDecimal.valueOf(200));

        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        cuenta.setSaldoInicial(BigDecimal.valueOf(300));

        Movimiento movimiento = new Movimiento();
        movimiento.setCuentaId(1L);
        movimiento.setSaldo(BigDecimal.valueOf(500));

        when(cuentaService.findByNumeroCuentaForUpdate(123L)).thenReturn(Optional.of(cuenta));
        when(cuentaService.update(any())).thenReturn(cuenta);
        when(movimientoService.create(any())).thenReturn(movimiento);

        Movimiento resultado = transactionService.procesarMovimiento(request);

        assertNotNull(resultado);
        assertEquals(BigDecimal.valueOf(500), resultado.getSaldo());
        verify(cuentaService, times(1)).update(any());
        verify(movimientoService, times(1)).create(any());
    }

    @Test
    void procesarMovimiento_cuentaNoEncontrada() {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setCuentaNumero(999L);
        request.setValor(BigDecimal.valueOf(100));

        when(cuentaService.findByNumeroCuentaForUpdate(999L)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> {
            transactionService.procesarMovimiento(request);
        });
    }

    @Test
    void procesarMovimiento_saldoInsuficiente() {
        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setCuentaNumero(123L);
        request.setValor(BigDecimal.valueOf(-500));

        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        cuenta.setSaldoInicial(BigDecimal.valueOf(100));

        when(cuentaService.findByNumeroCuentaForUpdate(123L)).thenReturn(Optional.of(cuenta));

        assertThrows(SaldoInsuficienteException.class, () -> {
            transactionService.procesarMovimiento(request);
        });
    }
}