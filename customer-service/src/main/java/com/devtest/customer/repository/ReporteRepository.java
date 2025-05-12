package com.devtest.customer.repository;

import com.devtest.customer.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    Optional<Reporte> findByClienteId(Long clienteId);

    void deleteByClienteId(Long clienteId);
}
