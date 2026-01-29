package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T22:01:14-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ReposicionMapperImpl implements ReposicionMapper {

    @Override
    public ReposicionResponseDTO toDTO(Reposicion reposicion) {
        if ( reposicion == null ) {
            return null;
        }

        ReposicionResponseDTO reposicionResponseDTO = new ReposicionResponseDTO();

        return reposicionResponseDTO;
    }

    @Override
    public Reposicion toEntity(ReposicionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reposicion reposicion = new Reposicion();

        reposicion.setFecha( dto.getFecha() );
        reposicion.setEstado( dto.getEstado() );
        reposicion.setDetallesReposicion( detallesReposicionRequestDTOListToDetalleReposicionList( dto.getDetallesReposicion() ) );

        return reposicion;
    }

    protected DetalleReposicion detallesReposicionRequestDTOToDetalleReposicion(DetallesReposicionRequestDTO detallesReposicionRequestDTO) {
        if ( detallesReposicionRequestDTO == null ) {
            return null;
        }

        DetalleReposicion detalleReposicion = new DetalleReposicion();

        detalleReposicion.setCantidad( detallesReposicionRequestDTO.getCantidad() );

        return detalleReposicion;
    }

    protected List<DetalleReposicion> detallesReposicionRequestDTOListToDetalleReposicionList(List<DetallesReposicionRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DetalleReposicion> list1 = new ArrayList<DetalleReposicion>( list.size() );
        for ( DetallesReposicionRequestDTO detallesReposicionRequestDTO : list ) {
            list1.add( detallesReposicionRequestDTOToDetalleReposicion( detallesReposicionRequestDTO ) );
        }

        return list1;
    }
}
