package com.nelricksoft.restaurante.restaurante.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String documento;
    private LocalDate fecha_nacimiento;
    private String telefono;
    private String correo;
    private String direccion;

    //***************  Relacion muchos a uno ************************ */
    @ManyToOne //********* 1. anotacion de la relacion *************/
    @JoinColumn(name = "id_tipo_descuento", nullable = false)//********* 2. Coloca de manera fisica en la base de datos ****/
    private TipoDescuento tipoDescuento;

}


