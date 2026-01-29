package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Reposicion.ReposicionNoExisteException;
import com.example.ProyectoSupermercado.Mapper.DetalleReposicionMapper;
import com.example.ProyectoSupermercado.Repository.DetalleReposicionRepository;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Repository.ReposicionRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleReposicionServiceImpl implements DetallesReposicionService {
    @Autowired
    private DetalleReposicionRepository detalleReposicionRepository;

    @Autowired
    private ReposicionRepository reposicionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleReposicionMapper detalleReposicionMapper;
    @Override
    public void crear(DetallesReposicionRequestDTO dto) {
        DetalleReposicion detalleReposicion = detalleReposicionMapper.toEntity(dto);
        Reposicion reposicion = reposicionRepository.findById(dto.getIdReposicion()).orElseThrow(()-> new ReposicionNoExisteException("La reposicion no existe."));
        Producto producto = productoRepository.findById(dto.getIdProducto()).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        reposicion.getDetallesReposicion().add(detalleReposicion);
        producto.getDetallesReposicion().add(detalleReposicion);
    }

    @Override
    public List<DetallesReposicionResponseDTO> obtenerDetallesPorReposicion(Long idReposicion) {
        Reposicion reposicion = reposicionRepository.findById(idReposicion).orElseThrow(()-> new ReposicionNoExisteException("La reposicion no existe."));
        List<DetallesReposicionResponseDTO> detallesReposicionResponseDTOS = new ArrayList<>();
        for (DetalleReposicion detalleReposicion:reposicion.getDetallesReposicion()){
            detallesReposicionResponseDTOS.add(detalleReposicionMapper.toDTO(detalleReposicion));
        }
        return detallesReposicionResponseDTOS;
    }
}
