package com.devtest.customer.controller.implementation;

import com.devtest.customer.controller.interfaces.IClienteController;
import com.devtest.customer.model.Cliente;
import com.devtest.customer.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController implements IClienteController {

    @Autowired
    private IClienteService clientService;

    @Override
    public ResponseEntity<Cliente> create(Cliente client) {
        return ResponseEntity.ok(clientService.create(client));
    }

    @Override
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public ResponseEntity<Cliente> findById(Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Cliente> update(Long id, Cliente client) {
        client.setId(id);
        return ResponseEntity.ok(clientService.update(client));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
