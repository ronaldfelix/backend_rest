package com.restaurant.repository.jpql;

import com.restaurant.dto.OrdenInfoDTO;
import com.restaurant.model.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<OrdenModel, Integer> {

    @Query("SELECT new com.restaurant.dto.OrdenInfoDTO(c.nombre, m.nombre, d.cantidad, d.total) " +
            "FROM OrdenModel o " +
            "JOIN o.cliente c " +
            "JOIN o.detalleOrdenes d " +
            "JOIN d.menu m " +
            "WHERE c.email = :email")
    List<OrdenInfoDTO> findHistorialByEmail(@Param("email") String email);
}
