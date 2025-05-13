package com.devtest.customer.controller.interfaces;

import com.devtest.customer.model.Cliente;
import com.devtest.customer.service.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
public interface IClienteController {

    @PostMapping
    ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO client);

    @GetMapping
    ResponseEntity<List<ClienteDTO>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<ClienteDTO> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO client);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
