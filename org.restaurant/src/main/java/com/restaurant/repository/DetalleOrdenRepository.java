package com.restaurant.repository;

import com.restaurant.model.DetalleOrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenModel, Integer> {
}
