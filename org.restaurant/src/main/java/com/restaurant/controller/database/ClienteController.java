package com.restaurant.controller.database;

import com.restaurant.model.ClienteModel;
import com.restaurant.service.database.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteModel> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getClienteById(@PathVariable("id") int id) {
        ClienteModel cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteModel> createCliente(@RequestBody ClienteModel cliente) {
        ClienteModel nuevoCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable("id") int id, @RequestBody ClienteModel cliente) {
        ClienteModel clienteActualizado = clienteService.updateCliente(id, cliente);
        if (clienteActualizado != null) {
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") int id) {
        boolean eliminado = clienteService.deleteCliente(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody ClienteModel cliente) {
        ClienteModel clienteExistente = clienteService.findByEmailAndClave(cliente.getEmail(), cliente.getClave());
        if (clienteExistente != null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("nombre", clienteExistente.getNombre());
            response.put("email", clienteExistente.getEmail());
            response.put("telefono", clienteExistente.getTelefono());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(Collections.singletonMap("message", "Invalid email or password"));
        }
    }

}
