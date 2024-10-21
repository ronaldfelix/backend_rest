package com.restaurant.service.jpql;

import com.restaurant.dto.OrdenInfoDTO;
import com.restaurant.repository.jpql.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    public List<OrdenInfoDTO> getHistorialByEmail(String email) {
        return historialRepository.findHistorialByEmail(email);
    }
}
