package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;
import com.example.ProyectoSupermercado.Repository.StockRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Integer consultarStock(Long idProducto) {
        return 0;
    }

    @Override
    public void reservarStock(Long idProducto, Integer cantidad) {

    }

    @Override
    public void incrementarStock(Long idProducto, Integer cantidad) {

    }

    @Override
    public void decrementarStock(Long idProducto, Integer cantidad) {

    }

    @Override
    public List<StockResponseDTO> stockCritico() {
        return List.of();
    }
}
