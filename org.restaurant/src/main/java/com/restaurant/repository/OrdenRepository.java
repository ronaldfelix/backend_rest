package com.restaurant.repository;

import com.restaurant.dto.PlatilloInfoDTO;
import com.restaurant.dto.OrdenInfoDTO;
import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenModel, Integer> {
    // JPQL historial
    @Query("SELECT new com.restaurant.dto.OrdenInfoDTO(c.nombre, m.nombre, d.cantidad, d.total) " +
            "FROM OrdenModel o " +
            "JOIN o.cliente c " +
            "JOIN o.detalleOrdenes d " +
            "JOIN d.menu m " +
            "WHERE c.email = :email")
    List<OrdenInfoDTO> findHistorialByEmail(@Param("email") String email);

    // JPQL filtro categoria y fecha
    @Query("SELECT new com.restaurant.dto.PlatilloInfoDTO(m.nombre, SUM(d.cantidad)) " +
            "FROM DetalleOrdenModel d " +
            "JOIN d.menu m " +
            "JOIN m.categoria c " +
            "JOIN d.orden o " +
            "WHERE o.fecha BETWEEN :fechaInicio AND :fechaFin AND c.nombreCategoria = :categoria " +
            "GROUP BY m.nombre " +
            "ORDER BY SUM(d.cantidad) DESC")
    List<PlatilloInfoDTO> findPlatillosByCategoriaAndDateRange(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("categoria") String categoria
    );

}