package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;

import java.util.List;

public interface StockService {
    Integer consultarStockDisponible(Long idProducto);
    void reservarStock (Long idProducto, Integer cantidad, Long idUsuario);
    void incrementarStock(Long idProducto, Integer cantidad, Long idUsuario);
    void decrementarStock(Long idProducto, Integer cantidad, Long idUsuario);
    List<StockResponseDTO>stockCritico();
    void liberarStock(Long idProducto, Integer cantidad, Long idUsuario);
}
