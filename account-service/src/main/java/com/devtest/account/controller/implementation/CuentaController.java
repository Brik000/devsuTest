package com.devtest.account.controller.implementation;

import com.devtest.account.mapper.CuentaMapper;
import com.devtest.account.model.Cuenta;
import com.devtest.account.service.dto.CuentaDTO;
import com.devtest.account.service.interfaces.ICuentaService;
import com.devtest.account.controller.interfaces.ICuentaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CuentaController implements ICuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @Override
    public ResponseEntity<Cuenta> create(CuentaDTO cuenta) {
        return ResponseEntity.ok(cuentaService.create(CuentaMapper.toEntity(cuenta)));
    }

    @Override
    public ResponseEntity<List<Cuenta>> findAll() {
        return ResponseEntity.ok(cuentaService.findAll());
    }

    @Override
    public ResponseEntity<Cuenta> findById(Long id) {
        return cuentaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Cuenta> update(Long id, CuentaDTO cuenta) {
        cuenta.setId(id);
        return ResponseEntity.ok(cuentaService.update(CuentaMapper.toEntity(cuenta)));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        cuentaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
