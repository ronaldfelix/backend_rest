package com.restaurant.repository.jpql;

import com.restaurant.model.DetalleOrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlatilloRepository extends JpaRepository<DetalleOrdenModel, Integer> {

    @Query(value = "CALL sp_findPlatillosByCategoriaAndDateRange(:fechaInicio, :fechaFin, :categoria)", nativeQuery = true)
    List<Object[]> findPlatillosByCategoriaAndDateRange(
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("categoria") String categoria
    );
}
