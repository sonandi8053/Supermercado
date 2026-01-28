package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import com.example.ProyectoSupermercado.Entity.Pedido;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Exception.Pedido.PedidoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Mapper.DetallesPedidoMapper;
import com.example.ProyectoSupermercado.Repository.DetallesPedidoRepository;
import com.example.ProyectoSupermercado.Repository.PedidoRepository;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallesPedidoServiceImpl implements DetallesPedidoService {
    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetallesPedidoMapper detallesPedidoMapper;
    @Override
    public DetallesPedido crear(DetallesPedidoRequestDTO dto, Pedido pedido) {
        Producto producto = productoRepository.findById(dto.getIdProductoAsociado()).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        DetallesPedido detallesPedido = detallesPedidoMapper.toEntity(dto);
        detallesPedido.setPedido(pedido);
        detallesPedido.setProducto(producto);
        detallesPedido.setCantidad(dto.getCantidad());
        detallesPedidoRepository.save(detallesPedido);
        producto.getDetalles().add(detallesPedido);
        return detallesPedido;
    }

    @Override
    public List<DetallesPedidoResponseDTO> obtenerDetallesPorPedido(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(()-> new PedidoNoExisteException("El pedido no existe."));
        List<DetallesPedido> detallesPedidos = pedido.getDetalles();
        List<DetallesPedidoResponseDTO> dtos = new ArrayList<>();
        for (DetallesPedido detallePedido: detallesPedidos){
            dtos.add(detallesPedidoMapper.toDTO(detallePedido));
        }
        return dtos;
    }

    @Override
    public Integer calcularSubTotal(Long idDetallePedido) {
        return 0;
    }
}
