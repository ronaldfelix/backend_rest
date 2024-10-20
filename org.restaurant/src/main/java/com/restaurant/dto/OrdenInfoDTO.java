package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenInfoDTO {
    private String cliente;
    private String platillo;
    private int cantidad;
    private double totalPagado;
}