package com.restaurant.controller;

import com.restaurant.dto.CategoriaConPlatillosDTO;
import com.restaurant.dto.OrdenInfoDTO;
import com.restaurant.model.OrdenModel;
import com.restaurant.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "http://localhost:5173")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<OrdenModel> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenModel> getOrdenById(@PathVariable("id") int id) {
        OrdenModel orden = ordenService.getOrdenById(id);
        if (orden != null) {
            return ResponseEntity.ok(orden);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdenModel> createOrden(@RequestBody OrdenModel orden) {
        OrdenModel nuevaOrden = ordenService.createOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenModel> updateOrden(@PathVariable("id") int id, @RequestBody OrdenModel orden) {
        OrdenModel ordenActualizada = ordenService.updateOrden(id, orden);
        if (ordenActualizada != null) {
            return ResponseEntity.ok(ordenActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable("id") int id) {
        boolean eliminado = ordenService.deleteOrden(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Ruta obtener historial
    @GetMapping("/cliente/email/{email}/historial")
    public ResponseEntity<List<OrdenInfoDTO>> getHistorialByEmail(@PathVariable("email") String email) {
        List<OrdenInfoDTO> historial = ordenService.getHistorialByEmail(email);
        return ResponseEntity.ok(historial);
    }

    //Ruta filtro por categoria y fecha
    @GetMapping("/platillos/categoria")
    public ResponseEntity<CategoriaConPlatillosDTO> getPlatillosByCategoriaAndDate(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin,
            @RequestParam("categoria") String categoria) {

        // Convertimos las fechas de tipo String a LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio + " 00:00:00", formatter);
        LocalDateTime fin = LocalDateTime.parse(fechaFin + " 23:59:59", formatter);

        CategoriaConPlatillosDTO resultado = ordenService.getPlatillosByCategoriaAndDate(inicio, fin, categoria);
        return ResponseEntity.ok(resultado);
    }
}
