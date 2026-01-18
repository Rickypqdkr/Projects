package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.cliente.ClienteRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.cliente.ClienteResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Cliente;
import com.nelricksoft.restaurante.restaurante.entities.TipoDescuento;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.ClienteRepository;
import com.nelricksoft.restaurante.restaurante.repositories.TipoDescuentoRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private final TipoDescuentoRepository tipoDescuentoRepository;


    public ClienteService(ClienteRepository clienteRepository, TipoDescuentoRepository tipoDescuentoRepository){
        this.tipoDescuentoRepository = tipoDescuentoRepository;
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO CrearCliente(ClienteRequestDTO clienteRequestDTO){
        //****** 1. Buscar la entidad relacionada (tipo de descuento) *****/
        TipoDescuento tipoDescuento = tipoDescuentoRepository.findById(clienteRequestDTO.getId_tipo_descuento())
        .orElseThrow(() -> new ResourceNotFoundExceptions("Tipo de descuento no encontrado con el ID: " + clienteRequestDTO.getId_tipo_descuento()));

        //***2. Mapea el DTO a la entidad cliente**** */
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(clienteRequestDTO.getNombre());
        nuevoCliente.setApellido(clienteRequestDTO.getApellido());
        nuevoCliente.setDocumento(clienteRequestDTO.getDocumento());
        nuevoCliente.setFecha_nacimiento(clienteRequestDTO.getFecha_nacimiento());
        nuevoCliente.setTelefono(clienteRequestDTO.getTelefono());
        nuevoCliente.setCorreo(clienteRequestDTO.getCorreo());
        nuevoCliente.setDireccion(clienteRequestDTO.getDireccion());

        //**** 3. Asignar una entidad relacionada ********** */
        nuevoCliente.setTipoDescuento(tipoDescuento);

        //**** 4. Guardar el nuevo cliente */
        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);

        //**** 5. Convertir a DTO de respuesta y retornar  */
        return Convertir_A_DTO(clienteGuardado);


    }

    public List<ClienteResponseDTO> ObtenerTodosLosClientes(){
        return clienteRepository.findAll().stream()
        .map(this::Convertir_A_DTO).collect(Collectors.toList());
    } 

    private ClienteResponseDTO Convertir_A_DTO(Cliente cliente){
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setDocumento(cliente.getDocumento());
        dto.setFecha_nacimiento(cliente.getFecha_nacimiento());
        dto.setTelefono(cliente.getTelefono());
        dto.setCorreo(cliente.getCorreo());
        dto.setDireccion(cliente.getDireccion());

        //**** Asignamos el nombre del descuento desde la entidad relacionada *********/
        dto.setTipoDescuentoNombre(cliente.getTipoDescuento().getNombre_descuento());
        return dto;
    }
}
