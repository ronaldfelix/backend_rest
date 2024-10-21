package com.restaurant.controller.database;

import com.restaurant.model.OrdenModel;
import com.restaurant.service.database.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
