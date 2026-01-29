package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Entity.MovimientoStock;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Usuario;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioNoExisteException;
import com.example.ProyectoSupermercado.Mapper.MovimientoStockMapper;
import com.example.ProyectoSupermercado.Repository.MovimientoStockRepository;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Repository.UsuarioRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.MovimientoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoStockServiceImpl implements MovimientoStockService {
    @Autowired
    private MovimientoStockRepository movimientoStockRepository;

    @Autowired
    private MovimientoStockMapper movimientoStockMapper;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void registrarMovimiento(MovimientoStockRequestDTO dto) {
        MovimientoStock movimientoStock = movimientoStockMapper.toEntity(dto);
        Producto producto = productoRepository.findById(dto.getIdProducto()).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        producto.getStock().getMovimientosStock().add(movimientoStock);
        usuario.getMovimientoStocks().add(movimientoStock);
    }

    @Override
    public List<MovimientoStockResponseDTO> verMovimientos() {
        List<MovimientoStock> movimientos = movimientoStockRepository.findAll();
        List<MovimientoStockResponseDTO> movimientoStockResponseDTOS = new ArrayList<>();
        for (MovimientoStock movimientoStock: movimientos){
            movimientoStockResponseDTOS.add(movimientoStockMapper.toDTO(movimientoStock));
        }
        return movimientoStockResponseDTOS;
    }

    @Override
    public List<MovimientoStockResponseDTO> verMovimientosPorProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        List<MovimientoStockResponseDTO> movimientoStockResponseDTOS = new ArrayList<>();
        for (MovimientoStock movimientoStock: producto.getStock().getMovimientosStock()){
            movimientoStockResponseDTOS.add(movimientoStockMapper.toDTO(movimientoStock));
        }
        return movimientoStockResponseDTOS;
    }
}
