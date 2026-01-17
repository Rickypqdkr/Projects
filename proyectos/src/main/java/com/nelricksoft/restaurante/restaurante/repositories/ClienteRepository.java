package com.nelricksoft.restaurante.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelricksoft.restaurante.restaurante.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
