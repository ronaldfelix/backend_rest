package com.restaurant.service;

import com.restaurant.model.CategoriaComidaModel;
import com.restaurant.repository.CategoriaComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaComidaService {

    @Autowired
    private CategoriaComidaRepository categoriaComidaRepository;

    // Obtener todas las categorías
    public List<CategoriaComidaModel> getAllCategorias() {
        return categoriaComidaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public CategoriaComidaModel getCategoriaById(int id) {
        Optional<CategoriaComidaModel> categoria = categoriaComidaRepository.findById(id);
        return categoria.orElse(null);
    }

    // Crear una nueva categoría
    public CategoriaComidaModel createCategoria(CategoriaComidaModel categoria) {
        return categoriaComidaRepository.save(categoria);
    }

    // Actualizar una categoría existente
    public CategoriaComidaModel updateCategoria(int id, CategoriaComidaModel categoriaActualizada) {
        Optional<CategoriaComidaModel> categoriaExistente = categoriaComidaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            CategoriaComidaModel categoria = categoriaExistente.get();
            categoria.setNombreCategoria(categoriaActualizada.getNombreCategoria());
            return categoriaComidaRepository.save(categoria);
        }
        return null;
    }

    // Eliminar una categoría
    public boolean deleteCategoria(int id) {
        Optional<CategoriaComidaModel> categoriaExistente = categoriaComidaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            categoriaComidaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
