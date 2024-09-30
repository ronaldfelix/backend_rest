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

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;
}