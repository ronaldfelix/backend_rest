package com.restaurant.controller.jpql;

import com.restaurant.dto.ReporteVentasDTO;
import com.restaurant.service.jpql.ReporteVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "http://localhost:5173")
public class ReporteVentasController {

    @Autowired
    private ReporteVentasService reporteVentasService;

    @GetMapping("/ventas")
    public List<ReporteVentasDTO> obtenerReporteVentas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        return reporteVentasService.obtenerReporteVentas(fechaInicio, fechaFin);
    }
}

