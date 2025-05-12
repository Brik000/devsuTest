package com.devtest.customer.service.implementation;

import com.devtest.customer.model.Cliente;
import com.devtest.customer.repository.ClienteRepository;
import com.devtest.customer.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private  ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
