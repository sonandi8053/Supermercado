package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;

import java.util.List;

public interface ReposicionService {
    ReposicionResponseDTO crear(ReposicionRequestDTO dto);
    void cambiarEstado(Long idReposicion);
    List<ReposicionResponseDTO>verReposiciones();
    List<ReposicionResponseDTO>verReposicionesPorReponedor(Long idReponedor);
}
