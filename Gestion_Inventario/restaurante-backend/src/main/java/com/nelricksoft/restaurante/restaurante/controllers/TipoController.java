package com.nelricksoft.restaurante.restaurante.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelricksoft.restaurante.restaurante.dtos.TipoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.TipoResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.TipoServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

    private final TipoServices tipoServices;
    public TipoController(TipoServices tipoServices){
        this.tipoServices = tipoServices;
    }
    
    //********** EndPoint crear una nueva sede ****/
    public ResponseEntity<TipoResponseDTO> CrearNuevoTipo(@Valid @RequestBody TipoRequestDTO tipoRequestDTO){
        TipoResponseDTO nuevoTipo = tipoServices.CrearTipo(tipoRequestDTO);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }

    //************* EndPoint Leer todos los tipos ***** */
    @GetMapping
    public ResponseEntity<List<TipoResponseDTO>> ObtenerTipos(){
        List<TipoResponseDTO> tipos = tipoServices.ObtenerTodosLosTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/hola/tipo")
    public String decirHola(){
        return "El servidor del restaurante esta funcionando";
    }
    //***************** Id para url ***************** */
    @GetMapping("/{id}")
    public ResponseEntity<TipoResponseDTO> ObtenerTipoPorId(@PathVariable Integer id){
        TipoResponseDTO tipo = tipoServices.ObtenerTipo(id);
        return ResponseEntity.ok(tipo);
    }

    //********* Editar ******************* */
    @PutMapping("/{id}")
    public ResponseEntity<TipoResponseDTO> ActulizarTipo(@PathVariable Integer id, @Valid @RequestBody TipoRequestDTO tipoRequestDTO){
        TipoResponseDTO tipoActulizado = tipoServices.ActulizarTipo(id, tipoRequestDTO);
        return ResponseEntity.ok(tipoActulizado);
    }

    //******* Eliminar ************* */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarTipo(@PathVariable Integer id){
        tipoServices.EliminarTipo(id);
        return ResponseEntity.noContent().build();
    }

}
