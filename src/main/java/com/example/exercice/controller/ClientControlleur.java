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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "client")

public class ClientControlleur {

    private final ClientService clientService;

    public ClientControlleur(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> creer(@RequestBody Client client) {
        clientService.creer(client);
        return new ResponseEntity<>("Client " + client.getEmail() + " à bien été creer !", HttpStatus.CREATED);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> rechercher() {
        return this.clientService.recherche();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }

}
