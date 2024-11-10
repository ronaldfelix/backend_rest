package com.restaurant.service.jpql;

import com.restaurant.dto.PlatilloInfoDTO;
import com.restaurant.repository.jpql.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatilloService {

    @Autowired
    private PlatilloRepository platilloRepository;

    public List<PlatilloInfoDTO> getPlatillosByCategoriaAndDateRange(LocalDate fechaInicio, LocalDate fechaFin, String categoria) {
        List<Object[]> results = platilloRepository.findPlatillosByCategoriaAndDateRange(fechaInicio, fechaFin, categoria);
        return results.stream()
                .map(result -> new PlatilloInfoDTO((String) result[0], ((Number) result[1]).longValue()))
                .collect(Collectors.toList());
    }
}
