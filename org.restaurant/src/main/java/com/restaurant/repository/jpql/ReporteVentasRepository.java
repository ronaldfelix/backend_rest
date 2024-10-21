package com.restaurant.repository.jpql;
import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReporteVentasRepository extends JpaRepository<OrdenModel, Integer> {

    @Query("SELECT new com.restaurant.dto.ReporteVentasDTO(o.fecha, SUM(o.totalPago)) " +
            "FROM OrdenModel o " +
            "WHERE o.fecha BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY o.fecha " +
            "ORDER BY SUM(o.totalPago) DESC")
    List<ReporteVentasDTO> findReporteVentas(
            @Param("fechaInicio") Date fechaInicio,  // Cambiamos a Date para ajustarse a lo que se espera en la base de datos
            @Param("fechaFin") Date fechaFin);

}



