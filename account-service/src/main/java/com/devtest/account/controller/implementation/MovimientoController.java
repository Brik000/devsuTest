package com.devtest.account.controller.implementation;

import com.devtest.account.controller.interfaces.IMovimientoController;
import com.devtest.account.model.Movimiento;
import com.devtest.account.service.dto.MovimientoDTO;
import com.devtest.account.service.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.devtest.account.mapper.MovimientoMapper;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovimientoController implements IMovimientoController {

    @Autowired
    private IMovimientoService movimientoService;

    @Override
    public ResponseEntity<MovimientoDTO> create(MovimientoDTO movimientoDto) {
        Movimiento saved = movimientoService.create(MovimientoMapper.toEntity(movimientoDto));
        return ResponseEntity.ok(MovimientoMapper.toDTO(saved));
    }

    @Override
    public ResponseEntity<List<MovimientoDTO>> findAll() {
        List<MovimientoDTO> lista = movimientoService.findAll()
                .stream()
                .map(MovimientoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @Override
    public ResponseEntity<MovimientoDTO> findById(Long id) {
        return movimientoService.findById(id)
                .map(m -> ResponseEntity.ok(MovimientoMapper.toDTO(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<MovimientoDTO> update(Long id, MovimientoDTO movimientoDto) {
        movimientoDto.setId(id);
        Movimiento updated = movimientoService.update(MovimientoMapper.toEntity(movimientoDto));
        return ResponseEntity.ok(MovimientoMapper.toDTO(updated));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        movimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
