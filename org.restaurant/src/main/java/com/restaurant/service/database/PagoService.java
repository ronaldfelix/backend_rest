package com.restaurant.service.database;

import com.restaurant.model.PagoModel;
import com.restaurant.repository.database.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Obtener todos los pagos
    public List<PagoModel> getAllPagos() {
        return pagoRepository.findAll();
    }

    // Obtener un pago por su ID
    public PagoModel getPagoById(int id) {
        Optional<PagoModel> pago = pagoRepository.findById(id);
        return pago.orElse(null);
    }

    // Crear un nuevo pago
    public PagoModel createPago(PagoModel pago) {
        return pagoRepository.save(pago);
    }

    // Actualizar un pago existente
    public PagoModel updatePago(int id, PagoModel pagoActualizado) {
        Optional<PagoModel> pagoExistente = pagoRepository.findById(id);
        if (pagoExistente.isPresent()) {
            PagoModel pago = pagoExistente.get();
            pago.setOrden(pagoActualizado.getOrden());
            pago.setMonto(pagoActualizado.getMonto());
            pago.setFechaPago(pagoActualizado.getFechaPago());
            return pagoRepository.save(pago);
        }
        return null;
    }

    // Eliminar un pago
    public boolean deletePago(int id) {
        Optional<PagoModel> pagoExistente = pagoRepository.findById(id);
        if (pagoExistente.isPresent()) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
