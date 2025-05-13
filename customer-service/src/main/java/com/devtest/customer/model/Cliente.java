package com.devtest.customer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contrasena;
    private String estado;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Reporte reporte;
}