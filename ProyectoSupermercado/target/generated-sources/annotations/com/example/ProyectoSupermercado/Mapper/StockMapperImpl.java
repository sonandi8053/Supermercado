package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.StockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;
import com.example.ProyectoSupermercado.Entity.Stock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T19:24:11-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public StockResponseDTO toDTO(Stock stock) {
        if ( stock == null ) {
            return null;
        }

        StockResponseDTO stockResponseDTO = new StockResponseDTO();

        stockResponseDTO.setId( stock.getId() );
        stockResponseDTO.setCantidadTotal( stock.getCantidadTotal() );

        return stockResponseDTO;
    }

    @Override
    public Stock toEntity(StockRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setCantidadTotal( dto.getCantidadTotal() );

        return stock;
    }
}
