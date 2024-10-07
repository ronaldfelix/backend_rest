package com.restaurant.repository;

import com.restaurant.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Integer> {
    List<MenuModel> findTop5ByNombreContainingIgnoreCase(String query);
}
