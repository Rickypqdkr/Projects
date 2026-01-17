package com.nelricksoft.restaurante.restaurante.dtos.cliente;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private LocalDate fecha_nacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    private String tipoDescuentoNombre;

}


