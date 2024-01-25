package com.example.exercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercice.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
