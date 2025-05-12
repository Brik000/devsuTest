package com.devtest.account.service.interfaces;

import com.devtest.account.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {
    Cuenta create(Cuenta cuenta);
    List<Cuenta> findAll();
    Optional<Cuenta> findById(Long id);
    void delete(Long id);
    Cuenta update(Cuenta cuenta);
    Optional<Cuenta> findByIdForUpdate(Long id);
}
