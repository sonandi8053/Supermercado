package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Repository.MovimientoStockRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.MovimientoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoStockServiceImpl implements MovimientoStockService {
    @Autowired
    private MovimientoStockRepository movimientoStockRepository;

    @Override
    public MovimientoStockResponseDTO registrarMovimiento(MovimientoStockRequestDTO dto) {
        return null;
    }

    @Override
    public List<MovimientoStockResponseDTO> verMovimientos() {
        return List.of();
    }

    @Override
    public List<MovimientoStockResponseDTO> verMovimientosPorProducto(Long id) {
        return List.of();
    }
}
