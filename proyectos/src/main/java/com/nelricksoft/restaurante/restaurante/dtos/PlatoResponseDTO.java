package com.nelricksoft.restaurante.restaurante.dtos;

import lombok.Data;

@Data
public class PlatoResponseDTO {
    private Integer id;
    private String nombre_plato;
    private String descripcion;
    private Double precio;
    private Integer tipoId;
    private String tipoNombre;
}
