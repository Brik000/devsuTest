package com.devtest.account.service.interfaces;

import com.devtest.account.model.Movimiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {
    Movimiento create(Movimiento movimiento);
    List<Movimiento> findAll();
    Optional<Movimiento> findById(Long id);
    void delete(Long id);
    Movimiento update(Movimiento movimiento);
}
