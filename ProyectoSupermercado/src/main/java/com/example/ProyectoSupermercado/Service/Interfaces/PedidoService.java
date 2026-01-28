package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;

import java.util.List;

public interface PedidoService {
    PedidoResponseDTO crearPedido(PedidoRequestDTO dto);
    List<PedidoResponseDTO> pedidosPropios (Long idUsuario);
    void cancelarPedido(Long idPedido);
    List<PedidoResponseDTO> verTodosLosPedidos();
    void cambiarEstadoPedido(Long idPedido);
}
