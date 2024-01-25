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
import com.example.exercice.enums.TypeAvis;
import com.example.exercice.services.AvisService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Contrôleur pour gérer les requêtes liées aux avis.
 * <p>
 * Ce contrôleur fournit des endpoints pour créer, rechercher et supprimer des
 * avis.
 */
@RestController
@RequestMapping(path = "avis", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvisControlleur {
    private AvisService avisService;

    /**
     * Constructeur pour initialiser le contrôleur avec le service nécessaire.
     *
     * @param avisService Le service utilisé pour gérer les opérations sur les avis.
     */
    public AvisControlleur(AvisService avisService) {
        this.avisService = avisService;
    }

    /**
     * Crée un nouvel avis et détermine son type (positif/négatif) basé sur le
     * contenu.
     *
     * @param avis L'avis à créer.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Avis avis) {
        String texte = avis.getTexte().toLowerCase();
        if (texte.contains("pas") || texte.contains("nul") || texte.contains("merde")) {
            avis.setType(TypeAvis.NEGATIF);
        } else {
            avis.setType(TypeAvis.POSITIF);
        }
        this.avisService.creer(avis);
    }

    /**
     * Recherche et retourne tous les avis existants.
     *
     * @return La liste des avis.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public @ResponseBody List<Avis> rechercher() {
        System.out.println();
        return this.avisService.rechercher();
    }

    /**
     * Supprime un avis basé sur son identifiant.
     *
     * @param id L'identifiant de l'avis à supprimer.
     * @return Une réponse indiquant le succès ou l'échec de l'opération.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> effacer(@PathVariable int id) {
        boolean isDeleted = this.avisService.effacer(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
