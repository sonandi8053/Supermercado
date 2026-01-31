package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T18:42:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class DetalleReposicionMapperImpl implements DetalleReposicionMapper {

    @Override
    public DetallesReposicionResponseDTO toDTO(DetalleReposicion detalleReposicion) {
        if ( detalleReposicion == null ) {
            return null;
        }

        DetallesReposicionResponseDTO detallesReposicionResponseDTO = new DetallesReposicionResponseDTO();

        detallesReposicionResponseDTO.setIdReposicion( detalleReposicionReposicionId( detalleReposicion ) );
        detallesReposicionResponseDTO.setIdProducto( detalleReposicionProductoId( detalleReposicion ) );
        detallesReposicionResponseDTO.setId( detalleReposicion.getId() );
        detallesReposicionResponseDTO.setCantidad( detalleReposicion.getCantidad() );

        return detallesReposicionResponseDTO;
    }

    @Override
    public DetalleReposicion toEntity(DetallesReposicionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DetalleReposicion detalleReposicion = new DetalleReposicion();

        detalleReposicion.setCantidad( dto.getCantidad() );

        return detalleReposicion;
    }

    private Long detalleReposicionReposicionId(DetalleReposicion detalleReposicion) {
        if ( detalleReposicion == null ) {
            return null;
        }
        Reposicion reposicion = detalleReposicion.getReposicion();
        if ( reposicion == null ) {
            return null;
        }
        Long id = reposicion.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long detalleReposicionProductoId(DetalleReposicion detalleReposicion) {
        if ( detalleReposicion == null ) {
            return null;
        }
        Producto producto = detalleReposicion.getProducto();
        if ( producto == null ) {
            return null;
        }
        Long id = producto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
