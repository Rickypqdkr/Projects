package com.nelricksoft.restaurante.restaurante.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonaResponseDTO {
    private Integer id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String cedula;
    private String email;
    private String telefono;
    @NotBlank
    private String cargo;
    
}
