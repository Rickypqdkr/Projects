package com.nelricksoft.restaurante.restaurante.dtos.cliente;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteRequestDTO {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String documento;
    @NotNull
    private LocalDate fecha_nacimiento;
    private String telefono;
    @Email
    private String correo;
    private String direccion;

    @NotNull(message = "El ID del tipo de descuento es obligatorio.")//**** el nombre de esta variable debe ser el mismo que se creo para la base de datos */
    private Integer id_tipo_descuento;
}
