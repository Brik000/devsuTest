package com.devtest.customer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reporte {
    @Id
    private Long id;

    private Long clienteId;

    @Lob
    private byte[] contenido;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}
