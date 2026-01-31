package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import com.example.ProyectoSupermercado.Entity.Pedido;

import java.util.List;

public interface DetallesPedidoService {
    DetallesPedido crear(DetallesPedidoRequestDTO dto, Pedido pedido);
    List<DetallesPedidoResponseDTO> obtenerDetallesPorPedido(Long idPedido);
}
