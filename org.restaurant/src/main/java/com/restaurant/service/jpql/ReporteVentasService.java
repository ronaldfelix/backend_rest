package com.restaurant.service.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.repository.jpql.ReporteVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteVentasService {

    @Autowired
    private ReporteVentasRepository reporteVentasRepository;

    public List<ReporteVentasDTO> getReporteVentas(Date fechaInicio, Date fechaFin) {
        return reporteVentasRepository.findReporteVentas(fechaInicio, fechaFin);
    }
}
