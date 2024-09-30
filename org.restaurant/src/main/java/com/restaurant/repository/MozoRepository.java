package com.restaurant.repository;

import com.restaurant.model.MozoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MozoRepository extends JpaRepository<MozoModel, Integer> {
}
