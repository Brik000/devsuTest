package com.devtest.account.controller.interfaces;

import com.devtest.account.model.Movimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movimientos")
public interface IMovimientoController {

    @PostMapping
    ResponseEntity<Movimiento> create(@RequestBody Movimiento movimiento);

    @GetMapping
    ResponseEntity<List<Movimiento>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Movimiento> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Movimiento> update(@PathVariable Long id, @RequestBody Movimiento movimiento);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
