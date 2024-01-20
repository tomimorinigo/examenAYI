package com.tomasmorinigo.ejercicio1.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {
    @Id @Column(name = "codigo_interno_servicio")
    private Integer codigoInternoServicio;
    private Integer codigoEanServicio;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer duracion;
}
