package com.nelricksoft.restaurante.restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Pedido pedido;

    @ManyToOne 
    @JoinColumn(name = "plato_id", nullable = false)
    private Plato plato;

    private Integer cantidad;
    private Double subtotal;
    
}
