package com.devtest.customer.controller.interfaces;

import com.devtest.customer.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
public interface IClienteController {

    @PostMapping
    ResponseEntity<Cliente> create(@RequestBody Cliente client);

    @GetMapping
    ResponseEntity<List<Cliente>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Cliente> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente client);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
