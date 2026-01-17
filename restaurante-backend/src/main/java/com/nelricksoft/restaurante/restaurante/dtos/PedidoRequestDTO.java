package com.nelricksoft.restaurante.restaurante.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.nelricksoft.restaurante.restaurante.entities.Cliente;
import com.nelricksoft.restaurante.restaurante.entities.DetallePedido;
import com.nelricksoft.restaurante.restaurante.entities.Sedes;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoRequestDTO {
    @NotBlank(message = "La fecha no debe estar vacia")
    private LocalDateTime fecha;

    @NotBlank(message = "El cliente no puede estar vacio")
    private Cliente cliente;

    private Sedes sede;

    private List<DetallePedido> detalles;

    private Double total;
}
