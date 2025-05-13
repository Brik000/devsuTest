package com.devtest.account.controller.interfaces;

import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.MovimientoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movimientos")
public interface IMovimientoController {

    @PostMapping
    ResponseEntity<MovimientoDTO> create(@RequestBody MovimientoDTO movimiento);

    @GetMapping
    ResponseEntity<List<MovimientoDTO>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<MovimientoDTO> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<MovimientoDTO> update(@PathVariable Long id, @RequestBody MovimientoDTO movimiento);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
