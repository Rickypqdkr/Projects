package com.nelricksoft.restaurante.restaurante.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoRequestDTO {
    //private Integer id;
    @NotBlank(message = "El tipo es obligatorio ")
    private String nombre;

    @NotBlank(message = "Este Campo es obligatorio ")
    private String descripcion;
}
