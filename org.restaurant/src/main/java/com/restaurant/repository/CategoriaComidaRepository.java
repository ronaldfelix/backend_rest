package com.restaurant.repository;

import com.restaurant.model.CategoriaComidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaComidaRepository extends JpaRepository<CategoriaComidaModel, Integer> {
}
