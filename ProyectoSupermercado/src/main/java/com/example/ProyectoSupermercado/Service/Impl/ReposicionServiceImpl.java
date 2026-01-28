package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Repository.ReposicionRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.ReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReposicionServiceImpl implements ReposicionService {
    @Autowired
    private ReposicionRepository reposicionRepository;

    @Override
    public ReposicionResponseDTO crear(ReposicionRequestDTO dto) {
        return null;
    }

    @Override
    public void cambiarEstado(Long idReposicion) {

    }

    @Override
    public void asignarReponedor(Long idUsuario) {

    }

    @Override
    public List<ReposicionResponseDTO> verReposiciones() {
        return List.of();
    }

    @Override
    public List<ReposicionResponseDTO> verReposicionesPorReponedor(Long idReponedor) {
        return List.of();
    }
}
