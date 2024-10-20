package com.restaurant.controller;

import com.restaurant.model.DetalleOrdenModel;
import com.restaurant.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-orden")
@CrossOrigin(origins = "http://localhost:5173")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    @GetMapping
    public List<DetalleOrdenModel> getAllDetallesOrden() {
        return detalleOrdenService.getAllDetallesOrden();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenModel> getDetalleOrdenById(@PathVariable("id") int id) {
        DetalleOrdenModel detalleOrden = detalleOrdenService.getDetalleOrdenById(id);
        if (detalleOrden != null) {
            return ResponseEntity.ok(detalleOrden);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetalleOrdenModel> createDetalleOrden(@RequestBody DetalleOrdenModel detalleOrden) {
        DetalleOrdenModel nuevoDetalleOrden = detalleOrdenService.createDetalleOrden(detalleOrden);
        return ResponseEntity.ok(nuevoDetalleOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrdenModel> updateDetalleOrden(@PathVariable("id") int id, @RequestBody DetalleOrdenModel detalleOrden) {
        DetalleOrdenModel detalleOrdenActualizado = detalleOrdenService.updateDetalleOrden(id, detalleOrden);
        if (detalleOrdenActualizado != null) {
            return ResponseEntity.ok(detalleOrdenActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleOrden(@PathVariable("id") int id) {
        boolean eliminado = detalleOrdenService.deleteDetalleOrden(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
