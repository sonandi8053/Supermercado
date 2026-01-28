package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.Rol;

import java.time.LocalDate;

public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia_hash;
    private Boolean es_activo;
    private LocalDate fecha_nac;
    private Rol rol;
}
