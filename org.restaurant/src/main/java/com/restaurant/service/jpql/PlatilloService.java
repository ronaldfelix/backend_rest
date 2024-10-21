package com.restaurant.service.jpql;

import com.restaurant.dto.PlatilloInfoDTO;
import com.restaurant.repository.jpql.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlatilloService {

    @Autowired
    private PlatilloRepository platilloRepository;

    public List<PlatilloInfoDTO> getPlatillosByCategoriaAndDateRange(LocalDate fechaInicio, LocalDate fechaFin, String categoria) {
        return platilloRepository.findPlatillosByCategoriaAndDateRange(fechaInicio, fechaFin, categoria);
    }
}
