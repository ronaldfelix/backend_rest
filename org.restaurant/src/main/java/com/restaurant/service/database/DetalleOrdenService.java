package com.restaurant.service.database;

import com.restaurant.model.DetalleOrdenModel;
import com.restaurant.repository.database.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    // Obtener todos los detalles de las órdenes
    public List<DetalleOrdenModel> getAllDetallesOrden() {
        return detalleOrdenRepository.findAll();
    }

    // Obtener un detalle de orden por ID
    public DetalleOrdenModel getDetalleOrdenById(int id) {
        Optional<DetalleOrdenModel> detalleOrden = detalleOrdenRepository.findById(id);
        return detalleOrden.orElse(null);
    }

    // Crear un nuevo detalle de orden
    public DetalleOrdenModel createDetalleOrden(DetalleOrdenModel detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    // Actualizar un detalle de orden existente
    public DetalleOrdenModel updateDetalleOrden(int id, DetalleOrdenModel detalleOrdenActualizado) {
        Optional<DetalleOrdenModel> detalleOrdenExistente = detalleOrdenRepository.findById(id);
        if (detalleOrdenExistente.isPresent()) {
            DetalleOrdenModel detalleOrden = detalleOrdenExistente.get();
            detalleOrden.setOrden(detalleOrdenActualizado.getOrden());
            detalleOrden.setMenu(detalleOrdenActualizado.getMenu());
            detalleOrden.setCantidad(detalleOrdenActualizado.getCantidad());
            detalleOrden.setPrecioUnitario(detalleOrdenActualizado.getPrecioUnitario());
            detalleOrden.setTotal(detalleOrdenActualizado.getTotal());
            return detalleOrdenRepository.save(detalleOrden);
        }
        return null;
    }

    // Eliminar un detalle de orden por ID
    public boolean deleteDetalleOrden(int id) {
        Optional<DetalleOrdenModel> detalleOrdenExistente = detalleOrdenRepository.findById(id);
        if (detalleOrdenExistente.isPresent()) {
            detalleOrdenRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
