package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class ReporteVentasDTO {
    private Date fecha;
    private double totalVentas;
}
