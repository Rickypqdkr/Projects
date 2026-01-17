package com.nelricksoft.restaurante.restaurante.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlatoRequestDTO {
    @NotBlank(message = "El nombre del plato no puede estar vacio")
    private String nombre_plato;
    private String descripcion;

    @NotBlank(message = "El precio del plato no puede ser nulo")
    private Double precio;
    
    private Integer tipoID;
    
}
