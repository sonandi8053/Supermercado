package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.Entity.Usuario;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioNoExisteException;
import com.example.ProyectoSupermercado.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsuarioNoExisteException("El usuario no existe."));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getContraseniaHash())
                .roles(usuario.getRol().name())
                .build();
    }
}


