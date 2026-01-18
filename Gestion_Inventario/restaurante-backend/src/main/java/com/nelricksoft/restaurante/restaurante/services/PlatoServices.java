package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.PlatoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PlatoResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Plato;
import com.nelricksoft.restaurante.restaurante.entities.Tipo;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.PlatoRepository;
import com.nelricksoft.restaurante.restaurante.repositories.TipoRepository;

@Service
public class PlatoServices {
    private final PlatoRepository platoRepository;
    private final TipoRepository tipoRepository;

    //********* Constructor ****************** */
    public PlatoServices(PlatoRepository platoRepository, TipoRepository tipoRepository){
        this.platoRepository = platoRepository;
        this.tipoRepository = tipoRepository;
    }

    //************** Metodos para crear un nuevo Plato ***/
    public PlatoResponseDTO CrearPlato(PlatoRequestDTO platoRequestDTO){
        //********** 1. Buscar la entidad relacionada (tipo) *****/
        Tipo tipo = tipoRepository.findById(platoRequestDTO.getTipoID())
        .orElseThrow(() -> new ResourceNotFoundExceptions("Tipo no encontrado con el ID: " + platoRequestDTO.getTipoID()));

        //********** 2. Convertir el DTO de entrada a entidad Plato****/
        Plato nuevoPlato = new Plato();
        nuevoPlato.setNombre_plato(platoRequestDTO.getNombre_plato());
        nuevoPlato.setDescripcion(platoRequestDTO.getDescripcion());
        nuevoPlato.setPrecio(platoRequestDTO.getPrecio());
        nuevoPlato.setTipo(tipo);

        //********** 3. Guardar el nuevo plato *****/
        Plato platoGuardado = platoRepository.save(nuevoPlato);

        //********** 4. Convertir a DTO de respuesta y retornar *****/
        return Convertir_A_DTO(platoGuardado);
    }

    //*********** Metodo Obtener todos los Platos ******/
    public List<PlatoResponseDTO> ObtenerTodosLosPlatos(){
        List<Plato> platos = platoRepository.findAll();
        return platos.stream().map(this::Convertir_A_DTO).collect(Collectors.toList());
    }
    //******** Metodo Convierte a DTO **********/
    private PlatoResponseDTO Convertir_A_DTO(Plato plato){
        PlatoResponseDTO dto = new PlatoResponseDTO();
        dto.setId(plato.getId());
        dto.setNombre_plato(plato.getNombre_plato());
        dto.setDescripcion(plato.getDescripcion());
        dto.setPrecio(plato.getPrecio());
        dto.setTipoId(plato.getTipo().getId());
        dto.setTipoNombre(plato.getTipo().getNombre());
        return dto;
    }

    /*************** Obtener Plato por Id ****************/
    public PlatoResponseDTO ObtenerPlatoPorId(Integer id){
        //*** Buscar plato por id */
        Plato plato = platoRepository.findById(id)
        .orElseThrow(() ->new ResourceNotFoundExceptions("Plato no encontrado por ID: " + id));
        //************* Retornar *************** */
        return Convertir_A_DTO(plato);
    }

    
    //********* Update ******************** */
    public PlatoResponseDTO ActualizarPlato(Integer id, PlatoRequestDTO platoRequestDTO){
        //**** 1. Buscar Plato que se quiere actualizar por id ***/
        Plato platoExistente = platoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundExceptions("Plato no encontrado con el ID: " + id));

        //*** Si esta el plato, Actualizar informacion ****/
        platoExistente.setNombre_plato(platoRequestDTO.getNombre_plato());
        platoExistente.setDescripcion(platoRequestDTO.getDescripcion());
        platoExistente.setPrecio(platoRequestDTO.getPrecio());
        
        //*** Buscar el tipo por ID y asignarlo ****/
        Tipo tipo = tipoRepository.findById(platoRequestDTO.getTipoID())
        .orElseThrow(() -> new ResourceNotFoundExceptions("Tipo no encontrado con el ID: " + platoRequestDTO.getTipoID()));
        platoExistente.setTipo(tipo);

        //****** Guardar actualizaciones del plato ***/
        Plato platoActualizado = platoRepository.save(platoExistente);

        //******** Convertir a DTO y devolver resultado */
        return Convertir_A_DTO(platoActualizado);

    }

    //*********** Delete -> Eliminar plato */
    public void EliminarPlato(Integer id){
        if(!platoRepository.existsById(id)){
            throw new ResourceNotFoundExceptions("No se puede encontrar el plato con el ID: " + id);
            
        }
    }
}
