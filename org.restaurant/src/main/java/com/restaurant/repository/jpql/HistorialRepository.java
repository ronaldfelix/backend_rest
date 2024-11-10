package com.restaurant.repository.jpql;

import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<OrdenModel, Integer> {

    @Query(value = "CALL sp_findHistorialByEmail(:emailCliente)", nativeQuery = true)
    List<Object[]> findHistorialByEmail(@Param("emailCliente") String email);
}
