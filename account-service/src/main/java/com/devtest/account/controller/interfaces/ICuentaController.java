package com.devtest.account.controller.interfaces;

import com.devtest.account.model.Cuenta;
import com.devtest.account.service.dto.CuentaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cuentas")
public interface ICuentaController {

    @PostMapping
    ResponseEntity<Cuenta> create(@RequestBody CuentaDTO cuenta);

    @GetMapping
    ResponseEntity<List<Cuenta>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Cuenta> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Cuenta> update(@PathVariable Long id, @RequestBody CuentaDTO cuenta);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
