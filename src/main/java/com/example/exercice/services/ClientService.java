package com.example.exercice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.exercice.entites.Client;
import com.example.exercice.repository.ClientRepository;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<?> creer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientDansLaBDD == null) {
            this.clientRepository.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body("Client creer avec succes");
        } else {
            // throw new IllegalArgumentException("Un client avec cet email existe deja");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Un client avec cet email existe déjà");
        }

    }

    public List<Client> recherche() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        return null;
    }

    public Client lireOuCreer(Client clientAcreer) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientDansLaBDD == null) {
            clientDansLaBDD = this.clientRepository.save(clientAcreer);

        }
        return clientDansLaBDD;
    }
}
