package com.restaurant.controller.jpql;

import com.restaurant.dto.OrdenInfoDTO;
import com.restaurant.service.jpql.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/{email}")
    public List<OrdenInfoDTO> getHistorialByEmail(@PathVariable("email") String email) {
        return historialService.getHistorialByEmail(email);
    }
}
