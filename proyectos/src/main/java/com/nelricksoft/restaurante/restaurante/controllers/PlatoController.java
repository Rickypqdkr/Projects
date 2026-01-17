package com.nelricksoft.restaurante.restaurante.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelricksoft.restaurante.restaurante.dtos.PlatoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PlatoResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.PlatoServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {
    private final PlatoServices platoServices;

    public PlatoController(PlatoServices platoServices){
        this.platoServices = platoServices;
    }

    //**** End point crear nuevo plato ******* */
    @PostMapping
    public ResponseEntity<PlatoResponseDTO> CrearNuevoPlato(@Valid @RequestBody PlatoRequestDTO platoRequestDTO){
        PlatoResponseDTO nuevoPlato = platoServices.CrearPlato(platoRequestDTO);
        return new ResponseEntity<>(nuevoPlato, HttpStatus.CREATED);
    }

    //******** End point leer todos los platos ****/
    @GetMapping 
    public ResponseEntity<List<PlatoResponseDTO>> ObtenerPlatos(){
        List<PlatoResponseDTO> platos = platoServices.ObtenerTodosLosPlatos();
        return ResponseEntity.ok(platos);
    }

    //**** El {id} en la url es una variable de ruta */
    @GetMapping("/{id}")
    public ResponseEntity<PlatoResponseDTO> ObtenerSedePorId(@PathVariable Integer id){
        PlatoResponseDTO plato = platoServices.ObtenerPlatoPorId(id);
        return ResponseEntity.ok(plato);
    }

    //******* Editar - Update ***************/
    @PutMapping("/{id}")
    public ResponseEntity<PlatoResponseDTO> ActulizarPlato(@PathVariable Integer id, @Valid @RequestBody PlatoRequestDTO platoRequestDTO ){
        PlatoResponseDTO platoActualizado = platoServices.ActualizarPlato(id, platoRequestDTO);
        return ResponseEntity.ok(platoActualizado);
    }

    //****** Eliminar ***********/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarPlato(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }
}
