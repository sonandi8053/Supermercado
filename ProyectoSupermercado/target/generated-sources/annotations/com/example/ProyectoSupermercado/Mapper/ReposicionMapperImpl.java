package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import com.example.ProyectoSupermercado.Entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T18:42:48-0300",
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

        reposicionResponseDTO.setIdUsuario( reposicionUsuarioId( reposicion ) );
        reposicionResponseDTO.setId( reposicion.getId() );
        reposicionResponseDTO.setFecha( reposicion.getFecha() );
        reposicionResponseDTO.setEstado( reposicion.getEstado() );

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

    private Long reposicionUsuarioId(Reposicion reposicion) {
        if ( reposicion == null ) {
            return null;
        }
        Usuario usuario = reposicion.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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
