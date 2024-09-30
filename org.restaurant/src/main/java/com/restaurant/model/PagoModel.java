package com.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pago")
public class PagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double monto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPago;
}