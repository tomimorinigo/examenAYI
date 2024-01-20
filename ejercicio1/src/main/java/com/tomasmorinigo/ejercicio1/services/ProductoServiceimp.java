package com.tomasmorinigo.ejercicio1.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomasmorinigo.ejercicio1.persistence.entities.Producto;
import com.tomasmorinigo.ejercicio1.persistence.repository.ProductoRepository;

@Service
public class ProductoServiceimp implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Producto> getAllProductos() {
        return (ArrayList<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteProductoById(Integer id) {
        productoRepository.deleteById(id);
    }
}
