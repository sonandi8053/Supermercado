package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoReposicion;

import java.time.LocalDateTime;

public class ReposicionResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private EstadoReposicion estado;
    private Long idUsuario;
}
