package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Stock;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoYaExisteException;
import com.example.ProyectoSupermercado.Mapper.ProductoMapper;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Repository.StockRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.ProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private StockRepository stockRepository;
    @Transactional
    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {

        if (dto == null || dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }

        if (dto.getPrecio() == null) {
            throw new IllegalArgumentException("El precio es obligatorio.");
        }

        if (productoRepository.existsByNombre(dto.getNombre())) {
            throw new ProductoYaExisteException("El producto ya existe.");
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre().trim());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setEsActivo(dto.getEsActivo());

        producto = productoRepository.save(producto);

        Stock stock = new Stock();
        stock.setProducto(producto);
        stock.setCantidadTotal(0);
        stock.setCantidadReservada(0);

        stock = stockRepository.save(stock);

        producto.setStock(stock);

        return productoMapper.toDTO(producto);
    }
    @Override
    public void editarProducto(Long id, ProductoRequestDTO dto) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setEsActivo(dto.getEsActivo());
        productoRepository.save(producto);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoResponseDTO> productoResponseDTOS = new ArrayList<>();
        for (Producto producto: productos){
            productoResponseDTOS.add(productoMapper.toDTO(producto));
        }
        return productoResponseDTOS;
    }

    @Override
    public void modificarActivo(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        producto.setEsActivo(!producto.getEsActivo());
    }
}
