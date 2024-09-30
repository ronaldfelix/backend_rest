package com.restaurant.controller;

import com.restaurant.model.MenuModel;
import com.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuModel> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuModel> getMenuById(@PathVariable("id") int id) {
        MenuModel menu = menuService.getMenuById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MenuModel> createMenu(@RequestBody MenuModel menu) {
        MenuModel nuevoMenu = menuService.createMenu(menu);
        return ResponseEntity.ok(nuevoMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuModel> updateMenu(@PathVariable("id") int id, @RequestBody MenuModel menu) {
        MenuModel menuActualizado = menuService.updateMenu(id, menu);
        if (menuActualizado != null) {
            return ResponseEntity.ok(menuActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable("id") int id) {
        boolean eliminado = menuService.deleteMenu(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
