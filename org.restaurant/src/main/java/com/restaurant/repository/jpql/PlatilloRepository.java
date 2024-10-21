package com.restaurant.repository.jpql;

import com.restaurant.dto.PlatilloInfoDTO;
import com.restaurant.model.DetalleOrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlatilloRepository extends JpaRepository<DetalleOrdenModel, Integer> {

    @Query("SELECT new com.restaurant.dto.PlatilloInfoDTO(m.nombre, SUM(d.cantidad)) " +
            "FROM DetalleOrdenModel d " +
            "JOIN d.menu m " +
            "JOIN m.categoria c " +
            "JOIN d.orden o " +
            "WHERE FUNCTION('DATE', o.fecha) BETWEEN :fechaInicio AND :fechaFin " +
            "AND c.nombreCategoria = :categoria " +
            "GROUP BY m.nombre " +
            "ORDER BY SUM(d.cantidad) DESC")
    List<PlatilloInfoDTO> findPlatillosByCategoriaAndDateRange(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("categoria") String categoria
    );
}
