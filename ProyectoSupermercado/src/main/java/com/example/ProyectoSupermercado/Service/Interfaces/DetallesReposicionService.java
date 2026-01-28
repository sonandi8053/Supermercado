package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;

import java.util.List;

public interface DetallesReposicionService {
    DetallesReposicionResponseDTO crear(DetallesReposicionRequestDTO dto);
    List<DetallesReposicionResponseDTO> obtenerDetallesPorReposicion(Long idReposicion);

}
