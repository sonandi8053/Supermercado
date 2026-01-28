package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;

import java.util.List;

public interface StockService {
    Integer consultarStock (Long idProducto);
    void reservarStock (Long idProducto, Integer cantidad);
    void incrementarStock(Long idProducto, Integer cantidad);
    void decrementarStock(Long idProducto, Integer cantidad);
    List<StockResponseDTO>stockCritico();
}
