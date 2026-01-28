package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetallesPedidoMapper {
    DetallesPedidoResponseDTO toDTO(DetallesPedido detallesPedido);
    DetallesPedido toEntity(DetallesPedidoRequestDTO dto);
}
