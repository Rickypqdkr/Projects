package com.nelricksoft.restaurante.restaurante.dtos;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class SedeRequestDTO {
    @NotBlank(message = "El nombre de la sede no puede estar vacia")
    private String nombreSede;

    @NotBlank(message = "La direccion de la sede no puede estar vacia")
    private String direccion;


    private String telefono;
}
