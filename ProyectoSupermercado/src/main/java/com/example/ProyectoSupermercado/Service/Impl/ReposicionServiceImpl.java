package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.Enums.EstadoReposicion;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import com.example.ProyectoSupermercado.Entity.Usuario;
import com.example.ProyectoSupermercado.Exception.Reposicion.ReposicionNoExisteException;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioNoExisteException;
import com.example.ProyectoSupermercado.Mapper.ReposicionMapper;
import com.example.ProyectoSupermercado.Repository.ReposicionRepository;
import com.example.ProyectoSupermercado.Repository.UsuarioRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesReposicionService;
import com.example.ProyectoSupermercado.Service.Interfaces.ReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReposicionServiceImpl implements ReposicionService {
    @Autowired
    private ReposicionRepository reposicionRepository;

    @Autowired
    private ReposicionMapper reposicionMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DetallesReposicionService detallesReposicionService;

    @Override
    public ReposicionResponseDTO crear(ReposicionRequestDTO dto) {
        Reposicion reposicion = new Reposicion();
        reposicion.setFecha(dto.getFecha());
        reposicion.setEstado(dto.getEstado());
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        reposicion.setUsuario(usuario);
        reposicionRepository.save(reposicion);
        for (DetallesReposicionRequestDTO dto1: dto.getDetallesReposicion()){
            detallesReposicionService.crear(dto1, reposicion);
        }
        reposicionRepository.save(reposicion);
        return reposicionMapper.toDTO(reposicion);
    }

    @Override
    public void cambiarEstado(Long idReposicion) {
        Reposicion reposicion = reposicionRepository.findById(idReposicion).orElseThrow(()-> new ReposicionNoExisteException("La reposicion no existe."));
        EstadoReposicion estadoReposicion = reposicion.getEstado();
        switch (estadoReposicion){
            case Creada -> reposicion.setEstado(EstadoReposicion.Aprobada);
            case Aprobada -> reposicion.setEstado(EstadoReposicion.Recibida);
            case Recibida -> throw new IllegalArgumentException("La reposicion ya fue entregada");
            default -> throw new IllegalArgumentException("El estado no existe");
        }
    }

    @Override
    public List<ReposicionResponseDTO> verReposiciones() {
        List <Reposicion> reposiciones = reposicionRepository.findAll();
        List <ReposicionResponseDTO> dtos = new ArrayList<>();
        for (Reposicion reposicion: reposiciones){
            dtos.add(reposicionMapper.toDTO(reposicion));
        }
        return dtos;
    }

    @Override
    public List<ReposicionResponseDTO> verReposicionesPorReponedor(Long idReponedor) {
        Usuario usuario = usuarioRepository.findById(idReponedor).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        List<ReposicionResponseDTO> dtos = new ArrayList<>();
        for (Reposicion reposicion:usuario.getReposiciones()){
            dtos.add(reposicionMapper.toDTO(reposicion));
        }
        return dtos;
    }
}
