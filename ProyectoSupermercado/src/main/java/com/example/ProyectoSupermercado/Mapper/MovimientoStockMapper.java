package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Entity.MovimientoStock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoStockMapper {
    MovimientoStockResponseDTO toDTO(MovimientoStock movimientoStock);
    MovimientoStock toEntity(MovimientoStockRequestDTO dto);
}
