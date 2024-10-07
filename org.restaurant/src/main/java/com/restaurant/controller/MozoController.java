package com.restaurant.controller;

import com.restaurant.model.MozoModel;
import com.restaurant.service.MozoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mozos")
public class MozoController {

    @Autowired
    private MozoService mozoService;

    @GetMapping
    public List<MozoModel> getAllMozos() {
        return mozoService.getAllMozos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MozoModel> getMozoById(@PathVariable("id") int id) {
        MozoModel mozo = mozoService.getMozoById(id);
        if (mozo != null) {
            return ResponseEntity.ok(mozo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MozoModel> createMozo(@RequestBody MozoModel mozo) {
        MozoModel nuevoMozo = mozoService.createMozo(mozo);
        return ResponseEntity.ok(nuevoMozo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MozoModel> updateMozo(@PathVariable("id") int id, @RequestBody MozoModel mozo) {
        MozoModel mozoActualizado = mozoService.updateMozo(id, mozo);
        if (mozoActualizado != null) {
            return ResponseEntity.ok(mozoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMozo(@PathVariable("id") int id) {
        boolean eliminado = mozoService.deleteMozo(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}