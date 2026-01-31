package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "http://localhost:5173")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<PedidoResponseDTO> crearPedido(@RequestBody PedidoRequestDTO dto) {
        PedidoResponseDTO pedidoCreado = pedidoService.crearPedido(dto);
        return new ResponseEntity<>(pedidoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<PedidoResponseDTO>> pedidosPropios(@PathVariable Long idUsuario) {
        List<PedidoResponseDTO> pedidos = pedidoService.pedidosPropios(idUsuario);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PatchMapping("/{idPedido}/cancelar")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long idPedido) {
        pedidoService.cancelarPedido(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<PedidoResponseDTO>> verTodosLosPedidos() {
        List<PedidoResponseDTO> pedidos = pedidoService.verTodosLosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PatchMapping("/{idPedido}/estado")
    public ResponseEntity<Void> cambiarEstadoPedido(@PathVariable Long idPedido) {
        pedidoService.cambiarEstadoPedido(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
