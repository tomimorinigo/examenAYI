package com.tomasmorinigo.ejercicio1.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.tomasmorinigo.ejercicio1.persistence.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    public Usuario findByNombre(String nombre);
}
