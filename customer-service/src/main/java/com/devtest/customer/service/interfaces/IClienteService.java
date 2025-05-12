package com.devtest.customer.service.interfaces;

import com.devtest.customer.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    Cliente create(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente update(Cliente cliente);
    void delete(Long id);
}
