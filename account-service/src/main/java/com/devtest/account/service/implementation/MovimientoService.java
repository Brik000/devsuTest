package com.devtest.account.service.implementation;

import com.devtest.account.model.Movimiento;
import com.devtest.account.repository.MovimientoRepository;
import com.devtest.account.service.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService implements IMovimientoService {

    @Autowired
    private  MovimientoRepository movimientoRepository;

    @Override
    public Movimiento create(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }
}
