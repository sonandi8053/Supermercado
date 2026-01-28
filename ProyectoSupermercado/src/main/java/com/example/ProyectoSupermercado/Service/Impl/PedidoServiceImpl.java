package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import com.example.ProyectoSupermercado.Entity.Enums.EstadoPedido;
import com.example.ProyectoSupermercado.Entity.Pedido;
import com.example.ProyectoSupermercado.Entity.Usuario;
import com.example.ProyectoSupermercado.Exception.Pedido.PedidoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Usuario.UsuarioNoExisteException;
import com.example.ProyectoSupermercado.Mapper.DetallesPedidoMapper;
import com.example.ProyectoSupermercado.Mapper.PedidoMapper;
import com.example.ProyectoSupermercado.Repository.DetallesPedidoRepository;
import com.example.ProyectoSupermercado.Repository.PedidoRepository;
import com.example.ProyectoSupermercado.Repository.UsuarioRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesPedidoService;
import com.example.ProyectoSupermercado.Service.Interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DetallesPedidoService detallesPedidoService;

    @Autowired
    private DetallesPedidoRepository detallesPedidoRepository;

    @Override
    public PedidoResponseDTO crearPedido(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setEstado(EstadoPedido.Creado);
        pedido.setFechaCreacion(LocalDate.now());
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        pedido.setUsuario(usuario);
        pedidoRepository.save(pedido);
        for (DetallesPedidoRequestDTO detallePedido: dto.getDetallesPedidoRequestDTOS()){
            DetallesPedido detallesPedido = detallesPedidoService.crear(detallePedido, pedido);
            pedido.getDetalles().add(detallesPedido);
        }
        pedidoRepository.save(pedido);
        usuario.getPedidos().add(pedido);
        return pedidoMapper.toDTO(pedido);
    }

    @Override
    public List<PedidoResponseDTO> pedidosPropios(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(()-> new UsuarioNoExisteException("El usuario no existe."));
        List<PedidoResponseDTO> pedidos = new ArrayList<>();
        for (Pedido pedido: usuario.getPedidos()){
            if (pedido.getEstado()!= EstadoPedido.Cancelado){
                pedidos.add(pedidoMapper.toDTO(pedido));
            }
        }
        return pedidos;
    }

    @Override
    public void cancelarPedido(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(()-> new PedidoNoExisteException("El pedido no existe."));
        pedido.setEstado(EstadoPedido.Cancelado);
    }

    @Override
    public List<PedidoResponseDTO> verTodosLosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoResponseDTO> dtos = new ArrayList<>();
        for(Pedido pedido: pedidos){
            dtos.add(pedidoMapper.toDTO(pedido));
        }
        return dtos;
    }

    @Override
    public void cambiarEstadoPedido(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(()-> new PedidoNoExisteException("El pedido no existe."));
        EstadoPedido estadoPedido = pedido.getEstado();
        switch (estadoPedido){
            case Creado -> pedido.setEstado(EstadoPedido.Reservado);
            case Reservado -> pedido.setEstado(EstadoPedido.En_Preparacion);
            case En_Preparacion -> pedido.setEstado(EstadoPedido.Entregado);
            case Entregado, Cancelado -> throw new IllegalStateException("El pedido ya está finalizado");
            default -> throw new IllegalStateException("Estado desconocido");
        }
    }
}
