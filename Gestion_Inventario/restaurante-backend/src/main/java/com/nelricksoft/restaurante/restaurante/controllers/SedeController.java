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

import com.nelricksoft.restaurante.restaurante.dtos.SedeRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.SedeResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.SedeServices;

import jakarta.validation.Valid;

@RestController//*********** Maneja Peticiones HTTP ************ */
@RequestMapping("/api/sedes")

public class SedeController {
    
    private final SedeServices sedeServices;

    public SedeController(SedeServices sedeServices){
        this.sedeServices = sedeServices;
    }

    //************** EndPoint para crear una nueva sede type =(POST) */
    @PostMapping
    public ResponseEntity<SedeResponseDTO> CrearNuevaSede(@Valid @RequestBody SedeRequestDTO sedeRequestDTO){
        SedeResponseDTO nuevaSede = sedeServices.CrearSede(sedeRequestDTO);
        return new ResponseEntity<>(nuevaSede, HttpStatus.CREATED);
    }

    //************** EndPoint para leer todas las sedes type(GET) */
    @GetMapping
    public ResponseEntity<List<SedeResponseDTO>> ObtenerSedes(){
        List<SedeResponseDTO> sedes = sedeServices.ObtenerTodasLasSedes();
        return ResponseEntity.ok(sedes);
    }
    
    

    @GetMapping("/hola")
    public String decirHola() {
        return "El servidor del restaurante esta funcionando";

    }

    //************ El {id} en la url es una variable de ruta */
    @GetMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> ObtenerSedePorId(@PathVariable Integer id){
        //****** 1. @PathVariable  extrae el valor de id de la url ********
        SedeResponseDTO sede = sedeServices.ObtenerSedePorId(id);
        return ResponseEntity.ok(sede);
    }

    //******* Editar ********** */
    @PutMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> ActualizarSede(@PathVariable Integer id, @Valid @RequestBody SedeRequestDTO sedeRequestDTO){
        SedeResponseDTO sedeActualizada = sedeServices.ActualizarSede(id, sedeRequestDTO);
        return ResponseEntity.ok(sedeActualizada);
    }
    //****** Eliminar ******* */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarSede(@PathVariable Integer id){
        sedeServices.EliminarSede(id);
        /**** 1. El codigo 204 Not Content es el standard para una eliminacion existosa */
        return ResponseEntity.noContent().build();
    }

}
