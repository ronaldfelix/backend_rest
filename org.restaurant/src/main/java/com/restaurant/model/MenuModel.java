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
@Table(name = "menú")
public class MenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;

    @Column(nullable = false, length = 32)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private double precio;

    @Column(nullable = false, length = 32)
    private String imagen_url;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaComidaModel categoria;
}