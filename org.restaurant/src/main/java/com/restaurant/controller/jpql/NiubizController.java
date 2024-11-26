package com.restaurant.controller.jpql;

import com.restaurant.service.jpql.NiubizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/niubiz")
@CrossOrigin(origins = "http://localhost:5173")
public class NiubizController {

    private final NiubizService niubizService;

    public NiubizController(NiubizService niubizService) {
        this.niubizService = niubizService;
    }

    @PostMapping("/generate-session-token")
    public ResponseEntity<Map<String, Object>> generateSessionToken(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Extraer el valor de 'amount' del cuerpo de la solicitud
            if (!requestBody.containsKey("amount") || !(requestBody.get("amount") instanceof Number)) {
                throw new IllegalArgumentException("El campo 'amount' es obligatorio y debe ser un número.");
            }
            double amount = ((Number) requestBody.get("amount")).doubleValue();

            // Generar token de acceso
            String accessToken = niubizService.generateAccessToken();
            response.put("accessToken", accessToken);
            System.out.println("Access Token generado: " + accessToken);

            // Generar token de sesión
            String sessionToken = niubizService.generateSessionToken(accessToken, amount);
            response.put("sessionToken", sessionToken);
            System.out.println("Session Token generado: " + sessionToken);

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Manejo de errores en la generación de tokens
            response.put("error", "Error al generar los tokens: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/generate-authorization-token")
    public ResponseEntity<Map<String, Object>> generateAuthorizationToken(
            @RequestParam double amount,
            @RequestParam String sessionToken,
            @RequestParam String purchaseNumber) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Generar token de acceso
            String accessToken = niubizService.generateAccessToken();
            response.put("accessToken", accessToken);

            // Generar token de autorización
            Map<String, Object> authorizationResponse = niubizService.generateAuthorizationToken(
                    accessToken, sessionToken, amount, purchaseNumber);
            response.putAll(authorizationResponse);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}