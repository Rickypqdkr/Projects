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

import com.nelricksoft.restaurante.restaurante.dtos.PersonaRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PersonaResponseDTO;
import com.nelricksoft.restaurante.restaurante.services.PersonaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    private final PersonaServices personaServices;
    
    public PersonaController(PersonaServices personaServices){
        this.personaServices = personaServices;
    }

    //*********** EndPoint crear una nueva persona ******/
    public ResponseEntity<PersonaResponseDTO> CrearNuevaPersona(@Valid @RequestBody PersonaRequestDTO personaRequestDTO){
        PersonaResponseDTO nuevaPersona = personaServices.CrearPersona(personaRequestDTO);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);

    }

    //************ EndPoint Leer todas las personas *****/
    
    @GetMapping
    public ResponseEntity<List<PersonaResponseDTO>> ObtenerPersonas(){
        List<PersonaResponseDTO> personas = personaServices.ObtenerTodasLasPersonas();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/hola")
    public String decirHola(){
        return "El servidor del restaurante esta funcionando";
    }

    //********************************************************/
    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> ObtenerPersonaPorId(@PathVariable Integer id){
        PersonaResponseDTO persona = personaServices.ObtenerPersonaPorId(id);
        return ResponseEntity.ok(persona);
    }

    //********* Editar ************* */
    @PutMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> ActualizarPersona(@PathVariable Integer id, @Valid @RequestBody PersonaRequestDTO personaRequestDTO){
        PersonaResponseDTO personaActualizada = personaServices.ActualizarPersona(id, personaRequestDTO);
        return ResponseEntity.ok(personaActualizada);
    }

    //********* Eliminar ******************************** */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarPersona(@PathVariable Integer id){
        personaServices.EliminarPersona(id);
        return ResponseEntity.noContent().build();
    }

}
