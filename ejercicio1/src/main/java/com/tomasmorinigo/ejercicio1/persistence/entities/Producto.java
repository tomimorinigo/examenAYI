package com.tomasmorinigo.ejercicio1.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id @Column(name = "id_producto")
    private Integer codigoInternoProducto;
    private Integer codigoEan;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer stock;
}
