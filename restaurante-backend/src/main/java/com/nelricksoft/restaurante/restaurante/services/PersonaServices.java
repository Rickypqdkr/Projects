package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.PersonaRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PersonaResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Personas;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.PersonaRepository;

@Service
public class PersonaServices {

    private final PersonaRepository personaRepository;

    //********* Constructor ****************** */
    public PersonaServices(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    //*************** Metodos crear nuevas personas *****/
    public PersonaResponseDTO CrearPersona(PersonaRequestDTO personaRequestDTO){
        Personas nuevaPersona = new Personas();

        //****** 1. DTO -> entidad Personas ***** */
        nuevaPersona.setNombre(personaRequestDTO.getNombre());
        nuevaPersona.setApellido(personaRequestDTO.getApellido());
        nuevaPersona.setCedula(personaRequestDTO.getCedula());
        nuevaPersona.setEmail(personaRequestDTO.getEmail());
        nuevaPersona.setTelefono(personaRequestDTO.getTelefono());
        nuevaPersona.setCargo(personaRequestDTO.getCargo());

        //******* 2. Guardar tipo en base de datos ***** */
        Personas personaGuardada = personaRepository.save(nuevaPersona);

        //****** 3. Entidad guardada -> DTO **********/
        return convertir_A_DTO(personaGuardada);
    }

    //******* Metodo para obtener las personas *********/
    public List<PersonaResponseDTO> ObtenerTodasLasPersonas(){
        //************ 1. Obtener  lista de personas *********/
        List<Personas> personas = personaRepository.findAll();

        //*********** 2. convertir cada entidad de la lista a DTO */
        return personas.stream().map(this::convertir_A_DTO).collect(Collectors.toList());

    }

    private PersonaResponseDTO convertir_A_DTO(Personas personas){
        PersonaResponseDTO dto = new PersonaResponseDTO();
        dto.setId(personas.getId());
        dto.setNombre(personas.getNombre());
        dto.setApellido(personas.getApellido());
        dto.setCedula(personas.getCedula());
        dto.setEmail(personas.getEmail());
        dto.setTelefono(personas.getTelefono());
        dto.setCargo(personas.getCargo());

        return dto;
    }

    //********* Metodo para obtener persona por id***** */
    public PersonaResponseDTO ObtenerPersonaPorId(Integer id){
        //***** 1. Buscar la persona por id.  findbyid **************
        Personas persona = personaRepository.findById(id)
        //****** 2.  si no la encuentra  lanza la excepcion *****
        .orElseThrow(() -> new ResourceNotFoundExceptions("Persona no encontrada con el ID: "+id));
        //******* 3. si la encuentra la convierte a DTO y devuelve *****/
        return convertir_A_DTO(persona);
    }

    //********** Update del  Crud para Persona ************ */
    public PersonaResponseDTO ActualizarPersona(Integer id, PersonaRequestDTO personaRequestDTO){
        //******* 1. Buscar si  la persona que se quiere actulizar existe ********** */
        Personas personaExistente = personaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExceptions("Persona no encontrada con el id: " + id));

        //******** 2. si Existe, se actualiza los datos con los DTOS */
        personaExistente.setNombre(personaRequestDTO.getNombre());
        personaExistente.setApellido(personaExistente.getApellido());
        personaExistente.setCedula(personaRequestDTO.getCedula());
        personaExistente.setEmail(personaRequestDTO.getEmail());
        personaExistente.setTelefono(personaRequestDTO.getTelefono());
        personaExistente.setCargo(personaRequestDTO.getCargo());

        //***** 3. Guardar entidad actulizada en DB */
        Personas personaActualizada = personaRepository.save(personaExistente);

        //************** Convertir a DTO ****************** */
        return convertir_A_DTO(personaActualizada);
    }

    //********* Eliminar del crud -> Eliminar Persona  ***/
    public void EliminarPersona(Integer id){
        //********** Verificar que la persona exista antes de eliminarla *****/
        if(!personaRepository.existsById(id)){
            throw new ResourceNotFoundExceptions("No se puede eliminar. Persona no encontrada con ID: " + id);
        }
        //*********** Elimina a la persona ******* */
        personaRepository.deleteById(id);
    }
    
}
