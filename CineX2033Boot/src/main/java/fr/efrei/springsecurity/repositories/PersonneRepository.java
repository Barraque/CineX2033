package fr.efrei.springsecurity.repositories;

import fr.efrei.springsecurity.models.Personne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface PersonneRepository  extends JpaRepository<Personne, Long> {
    }
