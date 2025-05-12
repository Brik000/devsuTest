package com.devtest.account.controller.implementation;

import com.devtest.account.controller.interfaces.IMovimientoController;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientoController implements IMovimientoController {

    @Autowired
    private  IMovimientoService movimientoService;

    @Override
    public ResponseEntity<Movimiento> create(Movimiento movimiento) {
        return ResponseEntity.ok(movimientoService.create(movimiento));
    }

    @Override
    public ResponseEntity<List<Movimiento>> findAll() {
        return ResponseEntity.ok(movimientoService.findAll());
    }

    @Override
    public ResponseEntity<Movimiento> findById(Long id) {
        return movimientoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Movimiento> update(Long id, Movimiento movimiento) {
        movimiento.setId(id);
        return ResponseEntity.ok(movimientoService.update(movimiento));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        movimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
