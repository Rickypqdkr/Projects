package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.TipoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.TipoResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Tipo;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.TipoRepository;

@Service
public class TipoServices {

    private final TipoRepository tipoRepository;

    //********************** Crear el constructor **** */
    public TipoServices(TipoRepository tipoRepository){
        this.tipoRepository = tipoRepository;
    }
    
    //*********Metodos crear nuevos tipos ******* */
    public TipoResponseDTO CrearTipo(TipoRequestDTO tipoRequestDTO){
        Tipo nuevoTipo = new Tipo();
        //********** 1. Convertir DTO a entidad tipo ******/
        nuevoTipo.setNombre(tipoRequestDTO.getNombre());
        nuevoTipo.setDescripcion(tipoRequestDTO.getDescripcion());

        //********* 2. Guardar tipo en base de datos**** */
        Tipo tipoGuardado = tipoRepository.save(nuevoTipo);

        //************ 3. Convertir la entidad guardada en la base de datos*** */
        return convertir_A_DTO(tipoGuardado);
    }

    //********** Metodo para obtener todos los tipos ***** */
    public List<TipoResponseDTO> ObtenerTodosLosTipos(){
        //******* 1. Obtener la lista de los tipos *** */
        List<Tipo> tipos = tipoRepository.findAll();

        //******* 2. Convertir cada entidad de la lista a DTO correspondiente */
        return tipos.stream().map(this::convertir_A_DTO).collect(Collectors.toList());
    }

    //******* Metodo privado para reutilizar logica de conversion */

    private TipoResponseDTO convertir_A_DTO(Tipo tipo){
        TipoResponseDTO dto = new TipoResponseDTO();
        dto.setId(tipo.getId()); /*** Preguntar ** */
        dto.setNombre(tipo.getNombre());
        dto.setDescripcion(tipo.getDescripcion());

        return dto;
    }

    /************** Metodo para obtener tipo por id ***********/
    public TipoResponseDTO ObtenerTipo(Integer id){
        Tipo tipo = tipoRepository.findById(id)
        .orElseThrow(() ->new ResourceNotFoundExceptions("Tipo no encontrado con el ID: " + id));

        return convertir_A_DTO(tipo);
    }

    //********* Update del CRUD ******** */
    public TipoResponseDTO ActulizarTipo(Integer id, TipoRequestDTO tipoRequestDTO){
        Tipo tipoExistente = tipoRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExceptions("Tipo no encontrado por el ID:" + id));
        //*********** Si existe tipo actualiza *************/
        tipoExistente.setNombre(tipoRequestDTO.getNombre());
        tipoExistente.setDescripcion(tipoRequestDTO.getDescripcion());

        //********* Guardar entidad en DB ************ */
        Tipo tipoActualizado = tipoRepository.save(tipoExistente);
        //********* Convertir a DTO **************** */
        return convertir_A_DTO(tipoActualizado);
    }

    //*********** Metodo Deliete del CRUD eliminar Tipo *****/
        public void EliminarTipo(Integer id){
            if(!tipoRepository.existsById(id)){
                throw new ResourceNotFoundExceptions("Nose puede encontrar Tipo por ID:"+ id);

            }
            tipoRepository.deleteById(id);
        

    }
}
