package com.restaurant.repository.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReporteVentasRepository extends JpaRepository<OrdenModel, Integer> {

    @Procedure(name = "sp_reporteVentas")
    List<ReporteVentasDTO> findReporteVentas(
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin);
}
