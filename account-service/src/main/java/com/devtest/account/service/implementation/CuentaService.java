package com.devtest.account.service.implementation;

import com.devtest.account.model.Cuenta;
import com.devtest.account.repository.CuentaRepository;
import com.devtest.account.service.interfaces.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Cuenta create(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Optional<Cuenta> findByNumeroCuentaForUpdate(Long id) {
        return cuentaRepository.findByNumeroCuentaForUpdate(id);
    }
}
