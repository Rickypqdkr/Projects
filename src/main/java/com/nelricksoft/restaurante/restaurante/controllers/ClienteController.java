package com.nelricksoft.restaurante.restaurante.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelricksoft.restaurante.restaurante.dtos.cliente.ClienteRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.cliente.ClienteResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @PostMapping
    public ResponseEntity <ClienteResponseDTO> CrearCliente(@Valid @RequestBody ClienteRequestDTO requestDTO){
        ClienteResponseDTO clienteCreado = clienteService.CrearCliente(requestDTO);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> ObtenerTodosLosClientes(){
        List<ClienteResponseDTO> clientes = clienteService.ObtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }
}
