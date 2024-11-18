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

    public List<OrdenModel> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    public OrdenModel getOrdenById(int id) {
        Optional<OrdenModel> orden = ordenRepository.findById(id);
        return orden.orElse(null);
    }

    public List<OrdenModel> getOrdenesPorEstado(String estado) {
        return ordenRepository.findByEstado(estado);
    }

    public OrdenModel createOrden(OrdenModel orden) {
        return ordenRepository.save(orden);
    }

    public boolean cambiarEstadoOrden(int id, String nuevoEstado) {
        Optional<OrdenModel> ordenOpt = ordenRepository.findById(id);
        if (ordenOpt.isPresent()) {
            OrdenModel orden = ordenOpt.get();
            orden.setEstado(nuevoEstado);
            ordenRepository.save(orden);
            return true;
        }
        return false;
    }
}
