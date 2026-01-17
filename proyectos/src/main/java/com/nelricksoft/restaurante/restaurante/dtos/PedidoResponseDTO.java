package com.nelricksoft.restaurante.restaurante.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.nelricksoft.restaurante.restaurante.entities.Cliente;
import com.nelricksoft.restaurante.restaurante.entities.DetallePedido;
import com.nelricksoft.restaurante.restaurante.entities.Sedes;

import lombok.Data;

@Data
public class PedidoResponseDTO {
    private Integer id;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Sedes sede;
    private List<DetallePedido> detalles;
    private Double total;
    
}
