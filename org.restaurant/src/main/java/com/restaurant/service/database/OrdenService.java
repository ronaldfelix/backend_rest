package com.restaurant.service.database;

import com.restaurant.model.OrdenModel;
import com.restaurant.repository.database.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    // Obtener todas las órdenes
    public List<OrdenModel> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    // Obtener una orden por su ID
    public OrdenModel getOrdenById(int id) {
        Optional<OrdenModel> orden = ordenRepository.findById(id);
        return orden.orElse(null);
    }

    // Crear una nueva orden
    public OrdenModel createOrden(OrdenModel orden) {
        return ordenRepository.save(orden);
    }

    // Actualizar una orden existente
    public OrdenModel updateOrden(int id, OrdenModel ordenActualizada) {
        Optional<OrdenModel> ordenExistente = ordenRepository.findById(id);
        if (ordenExistente.isPresent()) {
            OrdenModel orden = ordenExistente.get();
            orden.setCliente(ordenActualizada.getCliente());
            orden.setTotalPago(ordenActualizada.getTotalPago());
            orden.setFecha(ordenActualizada.getFecha());
            return ordenRepository.save(orden);
        }
        return null;
    }

    // Eliminar una orden
    public boolean deleteOrden(int id) {
        Optional<OrdenModel> ordenExistente = ordenRepository.findById(id);
        if (ordenExistente.isPresent()) {
            ordenRepository.deleteById(id);
            return true;
        }
        return false;
    }
}