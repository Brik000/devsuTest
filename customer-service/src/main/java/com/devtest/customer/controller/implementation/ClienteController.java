package com.devtest.customer.controller.implementation;

import com.devtest.customer.controller.interfaces.IClienteController;
import com.devtest.customer.mapper.ClienteMapper;
import com.devtest.customer.model.Cliente;
import com.devtest.customer.service.dto.ClienteDTO;
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
    public ResponseEntity<ClienteDTO> create(ClienteDTO client) {
        Cliente saved = clientService.create(ClienteMapper.toEntity(client));
        return ResponseEntity.ok(ClienteMapper.toDTO(saved));
    }

    @Override
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clientes = clientService.findAll()
                .stream()
                .map(ClienteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<ClienteDTO> findById(Long id) {
        return clientService.findById(id)
                .map(cliente -> ResponseEntity.ok(ClienteMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ClienteDTO> update(Long id, ClienteDTO client) {
        client.setId(id);
        return ResponseEntity.ok(ClienteMapper.toDTO(clientService.update(ClienteMapper.toEntity(client))));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
