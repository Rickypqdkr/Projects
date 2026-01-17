package com.nelricksoft.restaurante.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tipo {

    @Id //************* Primary key ***************** */
    @GeneratedValue(strategy = GenerationType.IDENTITY)//*
    private Integer id;
    private String nombre;
    private String descripcion;
    
}
