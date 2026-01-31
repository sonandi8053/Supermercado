package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Entity.MovimientoStock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T19:24:11-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class MovimientoStockMapperImpl implements MovimientoStockMapper {

    @Override
    public MovimientoStockResponseDTO toDTO(MovimientoStock movimientoStock) {
        if ( movimientoStock == null ) {
            return null;
        }

        MovimientoStockResponseDTO movimientoStockResponseDTO = new MovimientoStockResponseDTO();

        movimientoStockResponseDTO.setId( movimientoStock.getId() );
        movimientoStockResponseDTO.setTipoMovimiento( movimientoStock.getTipoMovimiento() );
        movimientoStockResponseDTO.setCantidad( movimientoStock.getCantidad() );
        movimientoStockResponseDTO.setFecha( movimientoStock.getFecha() );
        movimientoStockResponseDTO.setMotivo( movimientoStock.getMotivo() );

        return movimientoStockResponseDTO;
    }

    @Override
    public MovimientoStock toEntity(MovimientoStockRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MovimientoStock movimientoStock = new MovimientoStock();

        movimientoStock.setTipoMovimiento( dto.getTipoMovimiento() );
        movimientoStock.setCantidad( dto.getCantidad() );
        movimientoStock.setFecha( dto.getFecha() );
        movimientoStock.setMotivo( dto.getMotivo() );

        return movimientoStock;
    }
}
