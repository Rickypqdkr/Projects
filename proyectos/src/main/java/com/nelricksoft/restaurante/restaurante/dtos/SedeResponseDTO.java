package com.nelricksoft.restaurante.restaurante.dtos;

import lombok.Data;

@Data

public class SedeResponseDTO {
    private Integer id;
    private String nombreSede;
    private String direccion;
    private String telefono;
}
