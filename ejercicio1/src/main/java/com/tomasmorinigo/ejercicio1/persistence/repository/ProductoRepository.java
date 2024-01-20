package com.tomasmorinigo.ejercicio1.persistence.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tomasmorinigo.ejercicio1.persistence.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    public ArrayList<Producto> findAll();
}
