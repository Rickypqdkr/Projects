package com.nelricksoft.restaurante.restaurante.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nelricksoft.restaurante.restaurante.dtos.PedidoRequestDTO;
import com.nelricksoft.restaurante.restaurante.dtos.PedidoResponseDTO;
import com.nelricksoft.restaurante.restaurante.entities.Pedido;
import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;
import com.nelricksoft.restaurante.restaurante.repositories.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    //** Inyeccion de dependencias  *****/
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    //**** Metodos para crear un nuevo pedido ****/

    public PedidoResponseDTO CrearPedido(PedidoRequestDTO pedidoRequestDTO){
        // Convertir dto de entrada a entidad pedido **
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setFecha(pedidoRequestDTO.getFecha());
        nuevoPedido.setCliente(pedidoRequestDTO.getCliente());
        nuevoPedido.setSede(pedidoRequestDTO.getSede());
        
        // Asignar los detalles y la relación inversa antes de guardar
        List<com.nelricksoft.restaurante.restaurante.entities.DetallePedido> detalles = pedidoRequestDTO.getDetalles();
        if (detalles != null) {
            for (com.nelricksoft.restaurante.restaurante.entities.DetallePedido detalle : detalles) {
                detalle.setPedido(nuevoPedido);
            }
        }
        nuevoPedido.setDetalles(detalles);
        
        nuevoPedido.setTotal(pedidoRequestDTO.getTotal());

        // Guardar la entidad en la base de datos */
        Pedido pedidoGuardado = pedidoRepository.save(nuevoPedido);
        //***** COnvertir la entidad guardada a DTO */
        return Convertir_A_DTO(pedidoGuardado);
    }

    //**** Metodo para obtener todos los pedidos ***/
    public List<PedidoResponseDTO> ObtenerTodosLosPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(this::Convertir_A_DTO).collect(Collectors.toList());
    }

    // Metodo Convertir a DTO *****
    public PedidoResponseDTO Convertir_A_DTO(Pedido pedido){
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setFecha(pedido.getFecha());
        dto.setCliente(pedido.getCliente());
        dto.setCliente(pedido.getCliente());
        dto.setSede(pedido.getSede());
        dto.setDetalles(pedido.getDetalles());
        dto.setTotal(pedido.getTotal());

        return dto;

    }

    //**** Metodo para obtener Pedido por id */
    public PedidoResponseDTO ObtenerPedidoPorId(Integer id){
        Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundExceptions("Pedido no encontrado con el ID: " + id));
        return Convertir_A_DTO(pedido);

    }

    //** Update -> Actulizar pedido */
    public PedidoResponseDTO ActulizarPedido(Integer id, PedidoRequestDTO pedidoRequestDTO){
        Pedido pedidoExistente = pedidoRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundExceptions("Pedido no encontrado con el ID: " + id));
        Pedido pedidoActulizado = pedidoRepository.save(pedidoExistente);
        return Convertir_A_DTO(pedidoActulizado);

    }

    //*** Delete -> Eliminar pedido */
    public void EliminarPedido(Integer id){
        if(!pedidoRepository.existsById(id)){
            throw new ResourceNotFoundExceptions("Nose puede eliminar pedido no existente");

        }
        pedidoRepository.deleteById(id);
    }

}
