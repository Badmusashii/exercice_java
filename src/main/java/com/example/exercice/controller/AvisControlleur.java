package com.example.exercice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercice.entites.Avis;
import com.example.exercice.services.AvisService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(path = "avis", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvisControlleur {
    private AvisService avisService;

    public AvisControlleur(AvisService avisService) {
        this.avisService = avisService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Avis avis) {
        this.avisService.creer(avis);
    }

    @GetMapping
    public @ResponseBody List<Avis> rechercher() {
        return this.avisService.rechercher();
    }

    @DeleteMapping(path = "{id}")
    public void effacer(@PathVariable int id) {
        this.avisService.effacer(id);
    }
}
