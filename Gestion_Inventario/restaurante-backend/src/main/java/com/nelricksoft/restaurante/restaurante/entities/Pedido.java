package com.nelricksoft.restaurante.restaurante.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name =  "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sedes sede;

    @OneToMany(mappedBy = "pedido", cascade = jakarta.persistence.CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private List<DetallePedido> detalles;

    private Double total;

}
