package com.restaurant.service.database;

import com.restaurant.model.ClienteModel;
import com.restaurant.repository.database.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<ClienteModel> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su ID
    public ClienteModel getClienteById(int id) {
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    // Crear un nuevo cliente
    public ClienteModel createCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public ClienteModel updateCliente(int id, ClienteModel clienteActualizado) {
        Optional<ClienteModel> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            ClienteModel cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setEmail(clienteActualizado.getEmail());
            cliente.setClave(clienteActualizado.getClave());
            cliente.setTelefono(clienteActualizado.getTelefono());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // Eliminar un cliente por su ID
    public boolean deleteCliente(int id) {
        Optional<ClienteModel> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Logeo
    public ClienteModel findByEmailAndClave(String email, String clave) {
        List<ClienteModel> clientes = getAllClientes();
        for (ClienteModel cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getClave().equals(clave)) {
                return cliente;
            }
        }
        return null;
    }
}
