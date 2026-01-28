package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Enums.Rol;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto);
    void editarUsuario(Long id, UsuarioRequestDTO dto);
    List<UsuarioResponseDTO> mostrarUsuarios();
    List<UsuarioResponseDTO> mostrarUsuarioPorRol(Rol rol);
    UsuarioResponseDTO verPerfil(Long id);

}
