package com.restaurant.repository.jpql;

import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReporteVentasRepository extends JpaRepository<OrdenModel, Integer> {

    @Query(value = "CALL sp_findReporteVentas(:fechaInicio, :fechaFin)", nativeQuery = true)
    List<Object[]> findReporteVentasRaw(
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin);
}
