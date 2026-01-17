package com.nelricksoft.restaurante.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelricksoft.restaurante.restaurante.entities.Personas;

@Repository
public interface PersonaRepository extends JpaRepository<Personas, Integer> {

    
}
