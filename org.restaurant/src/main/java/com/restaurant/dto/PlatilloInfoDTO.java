package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatilloInfoDTO {
    private String nombrePlatillo;
    private long cantidadPedidos;
}
