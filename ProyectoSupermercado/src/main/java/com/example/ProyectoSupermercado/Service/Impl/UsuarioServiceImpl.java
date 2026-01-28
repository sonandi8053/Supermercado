package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Enums.Rol;
import com.example.ProyectoSupermercado.Entity.Usuario;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioNoExisteException;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioYaExiste;
import com.example.ProyectoSupermercado.Mapper.UsuarioMapper;
import com.example.ProyectoSupermercado.Repository.UsuarioRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        if (dto.getEmail() == null || dto.getContrasenia() == null || dto.getEmail().trim().isEmpty() || dto.getContrasenia().trim().isEmpty()){
            throw new IllegalArgumentException("Completar los campos obligatorios");
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())){
            throw new UsuarioYaExiste("El usuario ya existe.");
        }
        Usuario usuario = new Usuario();
        String contraseniaHash = passwordEncoder.encode(dto.getContrasenia());
        usuario.setEmail(dto.getEmail());
        usuario.setNombre(dto.getNombre());
        usuario.setContraseniaHash(contraseniaHash);
        usuario.setFecha_nac(dto.getFecha_nac());
        usuario.setRol(dto.getRol());
        usuario.setEs_activo(true);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public void editarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        usuario.setNombre(dto.getNombre());
        usuario.setFecha_nac(dto.getFecha_nac());
        usuario.setRol(dto.getRol());
        String contraseniaHash = passwordEncoder.encode(dto.getContrasenia());
        usuario.setContraseniaHash(contraseniaHash);
        usuario.setEmail(dto.getEmail());
    }

    @Override
    public List<UsuarioResponseDTO> mostrarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO>dtos = new ArrayList<>();
        for (Usuario usuario: usuarios){
            dtos.add(usuarioMapper.toDTO(usuario));
        }
        return dtos;
    }

    @Override
    public List<UsuarioResponseDTO> mostrarUsuarioPorRol(Rol rol) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> dtos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getRol().equals(rol)) {
                dtos.add(usuarioMapper.toDTO(usuario));
            }
        }
        return dtos;
    }

    @Override
    public UsuarioResponseDTO verPerfil(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        return usuarioMapper.toDTO(usuario);
    }
}
