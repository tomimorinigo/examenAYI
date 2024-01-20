package com.tomasmorinigo.ejercicio1.services;

import java.util.ArrayList;

import com.tomasmorinigo.ejercicio1.persistence.entities.Producto;

public interface ProductoService {
    public ArrayList<Producto> getAllProductos();
    public void saveProducto(Producto producto);
    public void deleteProductoById(Integer id);
}
