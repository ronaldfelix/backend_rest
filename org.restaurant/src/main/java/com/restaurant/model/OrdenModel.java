package com.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orden")
public class OrdenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double totalPago;

    @OneToMany(mappedBy = "orden")
    private List<DetalleOrdenModel> detalleOrdenes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fecha;
}