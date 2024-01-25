package com.example.exercice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercice.entites.Client;
import com.example.exercice.services.ClientService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Contrôleur pour gérer les requêtes liées aux clients.
 * <p>
 * Ce contrôleur fournit des endpoints pour créer, rechercher et lire les
 * détails des clients.
 */
@RestController
@RequestMapping(path = "client")

public class ClientControlleur {

    private final ClientService clientService;

    /**
     * Constructeur pour initialiser le contrôleur avec le service nécessaire.
     *
     * @param clientService Le service utilisé pour gérer les opérations sur les
     *                      clients.
     */
    public ClientControlleur(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Crée un nouveau client.
     *
     * @param client Le client à créer.
     * @return Une réponse avec le message de succès et le statut HTTP.
     */
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> creer(@RequestBody Client client) {
        clientService.creer(client);
        return new ResponseEntity<>("Client " + client.getEmail() + " à bien été creer !", HttpStatus.CREATED);
    }

    /**
     * Recherche et retourne tous les clients existants.
     *
     * @return La liste des clients.
     */
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> rechercher() {
        return this.clientService.recherche();
    }

    /**
     * Lit et retourne les détails d'un client basé sur son identifiant.
     *
     * @param id L'identifiant du client à lire.
     * @return Les détails du client.
     */
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }

}
