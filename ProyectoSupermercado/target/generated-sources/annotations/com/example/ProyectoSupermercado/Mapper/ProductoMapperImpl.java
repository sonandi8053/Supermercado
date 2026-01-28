package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Producto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T12:12:35-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoResponseDTO toDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();

        return productoResponseDTO;
    }

    @Override
    public Producto toEntity(ProductoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombre( dto.getNombre() );
        producto.setDescripcion( dto.getDescripcion() );
        producto.setPrecio( dto.getPrecio() );
        producto.setEs_activo( dto.getEs_activo() );

        return producto;
    }
}
