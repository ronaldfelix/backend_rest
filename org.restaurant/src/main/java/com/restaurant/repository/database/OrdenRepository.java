package com.restaurant.repository.database;

import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenModel, Integer> {

    // Método para buscar órdenes por estado
    List<OrdenModel> findByEstado(String estado);
}
