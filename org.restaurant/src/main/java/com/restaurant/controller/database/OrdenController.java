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

    @GetMapping("/estado/{estado}")
    public List<OrdenModel> getOrdenesPorEstado(@PathVariable("estado") String estado) {
        return ordenService.getOrdenesPorEstado(estado);
    }

    @PostMapping
    public ResponseEntity<OrdenModel> createOrden(@RequestBody OrdenModel orden) {
        orden.setEstado("Pendiente"); // Estado inicial
        OrdenModel nuevaOrden = ordenService.createOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }

    @PutMapping("/{id}/preparar")
    public ResponseEntity<Void> prepararOrden(@PathVariable int id) {
        boolean actualizado = ordenService.cambiarEstadoOrden(id, "Preparada");
        if (actualizado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/descartar")
    public ResponseEntity<Void> descartarOrden(@PathVariable int id) {
        boolean actualizado = ordenService.cambiarEstadoOrden(id, "Descartada");
        if (actualizado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
