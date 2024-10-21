package com.restaurant.service.database;

import com.restaurant.model.MozoModel;
import com.restaurant.repository.database.MozoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MozoService {

    @Autowired
    private MozoRepository mozoRepository;

    // Obtener todos los mozos
    public List<MozoModel> getAllMozos() {
        return mozoRepository.findAll();
    }

    // Obtener un mozo por ID
    public MozoModel getMozoById(int id) {
        Optional<MozoModel> mozo = mozoRepository.findById(id);
        return mozo.orElse(null);
    }

    // Crear un nuevo mozo
    public MozoModel createMozo(MozoModel mozo) {
        return mozoRepository.save(mozo);
    }

    // Actualizar un mozo existente
    public MozoModel updateMozo(int id, MozoModel mozoActualizado) {
        Optional<MozoModel> mozoExistente = mozoRepository.findById(id);
        if (mozoExistente.isPresent()) {
            MozoModel mozo = mozoExistente.get();
            mozo.setOrden(mozoActualizado.getOrden());
            return mozoRepository.save(mozo);
        }
        return null;
    }

    // Eliminar un mozo por ID
    public boolean deleteMozo(int id) {
        Optional<MozoModel> mozoExistente = mozoRepository.findById(id);
        if (mozoExistente.isPresent()) {
            mozoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
