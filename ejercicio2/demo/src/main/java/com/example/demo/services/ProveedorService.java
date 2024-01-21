package com.example.demo.services;

import com.example.demo.persistence.entities.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProveedorService {
   public ArrayList<Proveedor> getAllProveedores();
   public void saveProveedor(Proveedor proveedor);
   public void deleteProveedor(Long id);
   public void editProveedor(Proveedor proveedor);
   Optional<Proveedor> getProveedorById(Long id);
}
