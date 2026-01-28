package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Repository.DetalleReposicionRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReposicionServiceImpl implements DetallesReposicionService {
    @Autowired
    private DetalleReposicionRepository detalleReposicionRepository;

    @Override
    public DetallesReposicionResponseDTO crear(DetallesReposicionRequestDTO dto) {
        return null;
    }

    @Override
    public List<DetallesReposicionResponseDTO> obtenerDetallesPorReposicion(Long idReposicion) {
        return List.of();
    }
}
