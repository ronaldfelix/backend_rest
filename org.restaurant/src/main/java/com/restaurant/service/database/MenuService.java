package com.restaurant.service.database;

import com.restaurant.model.MenuModel;
import com.restaurant.repository.database.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // Obtener todos los ítems del menú
    public List<MenuModel> getAllMenus() {
        return menuRepository.findAll();
    }

    // Obtener un ítem del menú por su ID
    public MenuModel getMenuById(int id) {
        Optional<MenuModel> menu = menuRepository.findById(id);
        return menu.orElse(null);
    }

    // Crear un nuevo ítem en el menú
    public MenuModel createMenu(MenuModel menu) {
        return menuRepository.save(menu);
    }

    // Actualizar un ítem existente en el menú
    public MenuModel updateMenu(int id, MenuModel menuActualizado) {
        Optional<MenuModel> menuExistente = menuRepository.findById(id);
        if (menuExistente.isPresent()) {
            MenuModel menu = menuExistente.get();
            menu.setNombre(menuActualizado.getNombre());
            menu.setDescripcion(menuActualizado.getDescripcion());
            menu.setPrecio(menuActualizado.getPrecio());
            menu.setCategoria(menuActualizado.getCategoria());
            return menuRepository.save(menu);
        }
        return null;
    }

    // Eliminar un ítem del menú
    public boolean deleteMenu(int id) {
        Optional<MenuModel> menuExistente = menuRepository.findById(id);
        if (menuExistente.isPresent()) {
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<MenuModel> searchMenus(String query) {
        return menuRepository.findTop5ByNombreContainingIgnoreCase(query);
    }
}
