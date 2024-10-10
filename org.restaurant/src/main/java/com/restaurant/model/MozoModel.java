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
@Table(name = "mozo")
public class MozoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMozo;

    @Column(nullable = false, length = 32)
    private String nombre;

    @Column(nullable = false, length = 32)
    private String email;

    @Column(nullable = false, length = 32)
    private String clave;
    
    @Column(nullable = false, length = 10)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;
}