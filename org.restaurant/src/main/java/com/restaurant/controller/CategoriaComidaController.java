package com.restaurant.controller;

import com.restaurant.model.CategoriaComidaModel;
import com.restaurant.service.CategoriaComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaComidaController {

    @Autowired
    private CategoriaComidaService categoriaComidaService;

    @GetMapping
    public List<CategoriaComidaModel> getAllCategorias() {
        return categoriaComidaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaComidaModel> getCategoriaById(@PathVariable("id") int id) {
        CategoriaComidaModel categoria = categoriaComidaService.getCategoriaById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaComidaModel> createCategoria(@RequestBody CategoriaComidaModel categoria) {
        CategoriaComidaModel nuevaCategoria = categoriaComidaService.createCategoria(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaComidaModel> updateCategoria(@PathVariable("id") int id, @RequestBody CategoriaComidaModel categoria) {
        CategoriaComidaModel categoriaActualizada = categoriaComidaService.updateCategoria(id, categoria);
        if (categoriaActualizada != null) {
            return ResponseEntity.ok(categoriaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable("id") int id) {
        boolean eliminado = categoriaComidaService.deleteCategoria(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
