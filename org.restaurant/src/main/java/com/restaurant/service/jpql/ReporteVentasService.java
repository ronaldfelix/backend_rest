package com.restaurant.service.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.repository.jpql.ReporteVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteVentasService {

    @Autowired
    private ReporteVentasRepository reporteVentasRepository;

    public List<ReporteVentasDTO> obtenerReporteVentas(Date fechaInicio, Date fechaFin) {
        List<Object[]> rawResults = reporteVentasRepository.findReporteVentasRaw(fechaInicio, fechaFin);

        return rawResults.stream().map(result -> {
            // Mapeo manual de resultados
            Date fecha = (Date) result[0];
            double totalVentas = ((Number) result[1]).doubleValue();
            return new ReporteVentasDTO(fecha, totalVentas);
        }).collect(Collectors.toList());
    }
}
