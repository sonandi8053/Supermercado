package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Enums.Rol;
import com.example.ProyectoSupermercado.Service.Interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO dto) {
        UsuarioResponseDTO usuarioCreado = usuarioService.crearUsuario(dto);
        return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto) {
        usuarioService.editarUsuario(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> mostrarUsuarios() {
        List<UsuarioResponseDTO> usuarios = usuarioService.mostrarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioResponseDTO>> mostrarUsuarioPorRol(@PathVariable Rol rol) {
        List<UsuarioResponseDTO> usuarios = usuarioService.mostrarUsuarioPorRol(rol);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> verPerfil(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.verPerfil(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
