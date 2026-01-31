package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import com.example.ProyectoSupermercado.Entity.Usuario;

import java.util.List;

public interface DetallesReposicionService {
    void crear(DetallesReposicionRequestDTO dto, Reposicion reposicion);
    List<DetallesReposicionResponseDTO> obtenerDetallesPorReposicion(Long idReposicion);

}
