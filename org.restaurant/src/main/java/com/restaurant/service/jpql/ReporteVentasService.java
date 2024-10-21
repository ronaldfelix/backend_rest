package com.restaurant.service.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.repository.jpql.ReporteVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ReporteVentasService {
    @Autowired
    private ReporteVentasRepository reporteVentasRepository;

    public List<ReporteVentasDTO> getReporteVentasPorIntervaloDeTiempo(LocalDate fechaInicio, LocalDate fechaFin) {
        // Convertimos LocalDate a Date
        Date inicio = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fin = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return reporteVentasRepository.findReporteVentas(inicio, fin);
    }
}
