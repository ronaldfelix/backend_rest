package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriaConPlatillosDTO {
    private String nombreCategoria;
    private List<PlatilloInfoDTO> platillos;
}
