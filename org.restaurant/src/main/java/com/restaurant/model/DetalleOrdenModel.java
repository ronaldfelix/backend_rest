package com.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "detalle_orden")
public class DetalleOrdenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private MenuModel menu;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double precioUnitario;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double total;
}