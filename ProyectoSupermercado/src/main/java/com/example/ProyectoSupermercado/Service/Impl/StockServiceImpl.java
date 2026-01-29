package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.MovimientoStockRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;
import com.example.ProyectoSupermercado.Entity.Enums.TipoMovimiento;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Stock;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Mapper.StockMapper;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Repository.StockRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.MovimientoStockService;
import com.example.ProyectoSupermercado.Service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private MovimientoStockService movimientoStockService;

    @Override
    public Integer consultarStockDisponible(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        return producto.getStock().getCantidadTotal() - producto.getStock().getCantidadReservada();
    }

    @Override
    public void reservarStock(Long idProducto, Integer cantidad, Long idUsuario) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        Integer reservadaActual = producto.getStock().getCantidadReservada();
        Integer totalAReservar = reservadaActual + cantidad;
        producto.getStock().setCantidadReservada(totalAReservar);
        MovimientoStockRequestDTO movimientoStockRequestDTO = new MovimientoStockRequestDTO();
        movimientoStockRequestDTO.setIdProducto(idProducto);
        movimientoStockRequestDTO.setIdUsuario(idUsuario);
        movimientoStockRequestDTO.setFecha(LocalDate.now());
        movimientoStockRequestDTO.setCantidad(cantidad);
        movimientoStockRequestDTO.setTipoMovimiento(TipoMovimiento.Reserva);
        movimientoStockService.registrarMovimiento(movimientoStockRequestDTO);
    }

    @Override
    public void incrementarStock(Long idProducto, Integer cantidad, Long idUsuario) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        Integer cantidadTotalActual = producto.getStock().getCantidadTotal();
        Integer total = cantidadTotalActual + cantidad;
        producto.getStock().setCantidadTotal(total);
        MovimientoStockRequestDTO movimientoStockRequestDTO = new MovimientoStockRequestDTO();
        movimientoStockRequestDTO.setIdProducto(idProducto);
        movimientoStockRequestDTO.setIdUsuario(idUsuario);
        movimientoStockRequestDTO.setFecha(LocalDate.now());
        movimientoStockRequestDTO.setCantidad(cantidad);
        movimientoStockRequestDTO.setTipoMovimiento(TipoMovimiento.Ingreso);
        movimientoStockService.registrarMovimiento(movimientoStockRequestDTO);
    }

    @Override
    public void decrementarStock(Long idProducto, Integer cantidad, Long idUsuario) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        Integer cantidadTotalActual = producto.getStock().getCantidadTotal();
        Integer total = cantidadTotalActual - cantidad;
        producto.getStock().setCantidadTotal(total);
        MovimientoStockRequestDTO movimientoStockRequestDTO = new MovimientoStockRequestDTO();
        movimientoStockRequestDTO.setIdProducto(idProducto);
        movimientoStockRequestDTO.setIdUsuario(idUsuario);
        movimientoStockRequestDTO.setFecha(LocalDate.now());
        movimientoStockRequestDTO.setCantidad(cantidad);
        movimientoStockRequestDTO.setTipoMovimiento(TipoMovimiento.Egreso);
        movimientoStockService.registrarMovimiento(movimientoStockRequestDTO);
    }

    @Override
    public List<StockResponseDTO> stockCritico() {
        List<Stock> stocks = stockRepository.stockCriticos();
        List<StockResponseDTO> stockResponseDTOS = new ArrayList<>();
        for (Stock stock: stocks){
            stockResponseDTOS.add(stockMapper.toDTO(stock));
        }
        return stockResponseDTOS;
    }

    @Override
    public void liberarStock(Long idProducto, Integer cantidad, Long idUsuario) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        Integer nCantidadReservada= producto.getStock().getCantidadReservada() - cantidad;
        producto.getStock().setCantidadReservada(nCantidadReservada);
        producto.getStock().setCantidadTotal(producto.getStock().getCantidadTotal() + cantidad);
        MovimientoStockRequestDTO movimientoStockRequestDTO = new MovimientoStockRequestDTO();
        movimientoStockRequestDTO.setIdProducto(idProducto);
        movimientoStockRequestDTO.setIdUsuario(idUsuario);
        movimientoStockRequestDTO.setFecha(LocalDate.now());
        movimientoStockRequestDTO.setCantidad(cantidad);
        movimientoStockRequestDTO.setTipoMovimiento(TipoMovimiento.Liberacion);
        movimientoStockService.registrarMovimiento(movimientoStockRequestDTO);
    }


}
