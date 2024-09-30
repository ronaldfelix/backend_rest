package com.restaurant.controller;

import com.restaurant.model.PagoModel;
import com.restaurant.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;  

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<PagoModel> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoModel> getPagoById(@PathVariable("id") int id) {
        PagoModel pago = pagoService.getPagoById(id);
        if (pago != null) {
            return ResponseEntity.ok(pago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PagoModel> createPago(@RequestBody PagoModel pago) {
        PagoModel nuevoPago = pagoService.createPago(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoModel> updatePago(@PathVariable("id") int id, @RequestBody PagoModel pago) {
        PagoModel pagoActualizado = pagoService.updatePago(id, pago);
        if (pagoActualizado != null) {
            return ResponseEntity.ok(pagoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable("id") int id) {
        boolean eliminado = pagoService.deletePago(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
