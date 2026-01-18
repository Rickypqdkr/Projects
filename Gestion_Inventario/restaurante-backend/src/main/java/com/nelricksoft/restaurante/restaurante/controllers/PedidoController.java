package com.nelricksoft.restaurante.restaurante.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelricksoft.restaurante.restaurante.dtos.PedidoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PedidoResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    //**** Endpoint Crear nuevo pedido ***/
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> CrearNuevoPedido(@Valid @RequestBody PedidoRequestDTO pedidoRequestDTO){
        PedidoResponseDTO nuevoPedido = pedidoService.CrearPedido(pedidoRequestDTO);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    //***** Endopoint Leer todos los pedidos ***/
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> ObtenerPedidos(){
        List<PedidoResponseDTO> pedidos = pedidoService.ObtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    //** Obtener pedido por id */
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> ObtenerPedidoPorId(@PathVariable Integer id){
        PedidoResponseDTO pedido = pedidoService.ObtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    //****** Editar pedido ****/
    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> AcatulizarPedido(@PathVariable Integer id, @Valid @RequestBody PedidoRequestDTO pedidoRequestDTO){
        PedidoResponseDTO pedidoActualizado = pedidoService.ActulizarPedido(id, pedidoRequestDTO);
        return ResponseEntity.ok(pedidoActualizado);
    }

    //***** Eliminar pedido *** */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarPedido(@PathVariable Integer id){
        pedidoService.EliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
    
}
