package com.nelricksoft.restaurante.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre_plato;
    private String descripcion;
    private Double precio;

    @ManyToOne
    @JoinColumn(name =  "tipo_id")
    private Tipo tipo;
}
