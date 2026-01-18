package com.nelricksoft.restaurante.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelricksoft.restaurante.restaurante.entities.TipoDescuento;

public interface TipoDescuentoRepository extends JpaRepository<TipoDescuento,Integer>{
    
}
