package com.devtest.account.controller.implementation;

import com.devtest.account.controller.interfaces.ITransactionController;
import com.devtest.account.exception.AccountNotFoundException;
import com.devtest.account.exception.SaldoInsuficienteException;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;
import com.devtest.account.service.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController implements ITransactionController {

    @Autowired
    private  ITransactionService transactionService;

    @Override
    public ResponseEntity<?> procesar(TransactionRequestDTO request) {
        try {
            Movimiento movimiento = transactionService.procesarMovimiento(request);
            return ResponseEntity.ok(movimiento);
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            return ResponseEntity
                    .status(404)
                    .body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body("Error inesperado: " + e.getMessage());
        }
    }
}
