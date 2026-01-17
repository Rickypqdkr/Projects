package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.SedeRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.SedeResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Sedes;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.SedeRepository;

@Service//******* Indica la logica del negocio *********************** */

public class SedeServices {
    
    private final SedeRepository sedeRepository;

    //********** Inyeccion de dependencias por constructor ************* */
    //************* Construcotr que inyecta las dependencias que se usan nivel global del proyecto*** */
    public SedeServices(SedeRepository sedeRepository){
        this.sedeRepository = sedeRepository;
    }

    //************ Metodos para crear una nueva sede *********** */
    public SedeResponseDTO CrearSede(SedeRequestDTO sedeRequestDTO){
        //********** 1. Convertir el DTo de entrada a una entidad sede */
        Sedes nuevaSede = new Sedes();
        nuevaSede.setNombreSede(sedeRequestDTO.getNombreSede());
        nuevaSede.setDireccion(sedeRequestDTO.getDireccion());
        nuevaSede.setTelefono(sedeRequestDTO.getTelefono());

        //********** 2. Guardadr la entidad en la base de datos ***/
        Sedes sedeGuardada = sedeRepository.save(nuevaSede);

        //********** 3. Convertir la entidad guardad en la base de datos */
        return convertir_A_DTO(sedeGuardada);
    }

    //***************** Metodo para obtener todas las sedes  */
    public List<SedeResponseDTO> ObtenerTodasLasSedes(){
        //******* 1. Obtenemos la lista de todas las entidades  */
        List<Sedes> sedes = sedeRepository.findAll();

        //******* 2. Convertimos cada entidad de la lista a su DTO Correspondiente */
        return sedes.stream().map(this::convertir_A_DTO).collect(Collectors.toList());
    }

    //************** Metodo privado para retulizar la logica de conversion */
    private SedeResponseDTO convertir_A_DTO(Sedes sede){
        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setId(sede.getId());
        dto.setNombreSede(sede.getNombreSede());
        dto.setDireccion(sede.getDireccion());
        dto.setTelefono(sede.getTelefono());

        return dto;
    }

    //********** Metodo para obtener sede por id ****/
    public SedeResponseDTO ObtenerSedePorId(Integer id){
        //******** 1. Buscar la sede por id. findbyid -> devuelve un optional */
        Sedes sede = sedeRepository.findById(id)
        //****    2. si no la encuentra se lanza nuestra excepcion personalizada *** */
            .orElseThrow(() ->new ResourceNotFoundExceptions("Sede no encontrada con el ID: "+id));/*** se uso arrow function */
        //******* 3. si la encuentra la convierte a DTO y la devuelve */
        return convertir_A_DTO(sede);


    }
    //*************** Update del CRUD ********************************* */
    public SedeResponseDTO ActualizarSede(Integer id, SedeRequestDTO sedeRequestDTO){
        //***** 1. Buscar si la sede que se quiere actualizar existe *****/
        Sedes sedeExistente = sedeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExceptions("Sede no encontrada con el ID: "+id));

        //***** 2. Si existe, se actualiza los datos con los DTOs**************** */
        sedeExistente.setNombreSede(sedeRequestDTO.getNombreSede());
        sedeExistente.setDireccion(sedeRequestDTO.getDireccion());
        sedeExistente.setTelefono(sedeRequestDTO.getTelefono());

        //**** 3. Guardar entidad actualizad en la base de datos  */
        Sedes sedeActualizada = sedeRepository.save(sedeExistente);

        //****** 4. COnvertir a DTO y devolver el resultado *** */

        return convertir_A_DTO(sedeActualizada);

    }

    //******** Metodo para eliminar sede  */
    public void EliminarSede(Integer id){
        //***** 1. Verificamos que la sede exista antes de borrarla  */
        if(!sedeRepository.existsById(id)){
            throw new ResourceNotFoundExceptions( "No se puede eliminar. Sede no encontrada con ID :"+id);

        }

        //****** 2. Si existe se elimina la sede  */
        sedeRepository.deleteById(id);

    }
}
