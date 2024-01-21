package com.tomasmorinigo.ejercicio1.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_usuario")
    private Integer id;
    private String nombre;
    @Column(name = "password_usuario")
    private String contrasenia;
}
