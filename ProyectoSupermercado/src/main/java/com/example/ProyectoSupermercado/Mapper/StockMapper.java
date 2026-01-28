package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.StockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;
import com.example.ProyectoSupermercado.Entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {
    StockResponseDTO toDTO(Stock stock);
    Stock toEntity(StockRequestDTO dto);
}
