package com.devtest.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente extends Persona {

    @Id
    private Long id;

    private String contrasena;
    private String estado;
}