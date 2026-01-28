package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoResponseDTO toDTO(Pedido pedido);
    Pedido toEntity(PedidoRequestDTO dto);
}
