package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Entity.MovimientoStock;

import java.util.List;

public interface MovimientoStockService {
    MovimientoStockResponseDTO registrarMovimiento(MovimientoStockRequestDTO dto);
    List<MovimientoStockResponseDTO> verMovimientos();
    List<MovimientoStockResponseDTO> verMovimientosPorProducto(Long id);
}
