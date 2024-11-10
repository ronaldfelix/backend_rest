package com.restaurant.controller.jpql;

import com.restaurant.dto.PlatilloInfoDTO;
import com.restaurant.service.jpql.PlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/platillos")
@CrossOrigin(origins = "http://localhost:5173")
public class PlatilloController {

    @Autowired
    private PlatilloService platilloService;

    @GetMapping("/filtro")
    public List<PlatilloInfoDTO> getPlatillosByCategoriaAndDateRange(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam("categoria") String categoria) {
        return platilloService.getPlatillosByCategoriaAndDateRange(fechaInicio, fechaFin, categoria);
    }
}
