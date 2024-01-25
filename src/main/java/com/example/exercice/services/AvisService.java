package com.example.exercice.services;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.exercice.entites.Avis;
import com.example.exercice.entites.Client;

import com.example.exercice.repository.AvisRepository;

@Service
public class AvisService {

    private ClientService clientService;
    private AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository, ClientService clientService) {
        this.avisRepository = avisRepository;
        this.clientService = clientService;
    }

    public void creer(Avis avis) {
        Client client = this.clientService.lireOuCreer(avis.getClient());
        avis.setClient(client);
        this.avisRepository.save(avis);
    }

    public List<Avis> rechercher() {

        return this.avisRepository.findAll();

    }

    public boolean effacer(int id) {
        if (!this.avisRepository.existsById(id)) {
            return false;
        }
        try {
            this.avisRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
