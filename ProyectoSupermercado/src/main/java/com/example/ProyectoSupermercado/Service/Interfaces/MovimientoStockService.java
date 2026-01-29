package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;

import java.util.List;

public interface MovimientoStockService {
    void registrarMovimiento(MovimientoStockRequestDTO dto);
    List<MovimientoStockResponseDTO> verMovimientos();
    List<MovimientoStockResponseDTO> verMovimientosPorProducto(Long id);
}
