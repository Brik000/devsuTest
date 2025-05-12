package com.devtest.account.controller.interfaces;

import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.TransactionRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transactions")
public interface ITransactionController {

    @PostMapping
    ResponseEntity<?> procesar(@RequestBody TransactionRequestDTO request);
}