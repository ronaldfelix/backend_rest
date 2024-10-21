package com.restaurant.controller.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.service.jpql.ReporteVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reporte-ventas")
@CrossOrigin(origins = "http://localhost:5173")
public class ReporteVentasController {

    @Autowired
    private ReporteVentasService reporteVentasService;

    @GetMapping("/intervalo")
    public List<ReporteVentasDTO> getReporteVentasPorIntervaloDeTiempo(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        return reporteVentasService.getReporteVentasPorIntervaloDeTiempo(fechaInicio, fechaFin);
    }
}