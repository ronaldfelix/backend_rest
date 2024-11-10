package com.restaurant.controller.jpql;

import com.restaurant.service.jpql.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "http://localhost:5173")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Object[]> getHistorialByEmail(@RequestParam("email") String email) {
        return historialService.getHistorialByEmail(email);
    }
}
