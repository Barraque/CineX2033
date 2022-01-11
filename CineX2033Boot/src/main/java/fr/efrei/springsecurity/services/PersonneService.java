package fr.efrei.springsecurity.services;


import fr.efrei.springsecurity.models.Personne;
import fr.efrei.springsecurity.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {


    @Autowired
    PersonneRepository personneRepository;

    public Personne savePersonne(final Personne personne){

        return personneRepository.save(personne);
    }

    public Personne getPersonne(Long id){
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.get();
    }

    public List<Personne> getallPersonne(){
        return personneRepository.findAll();
    }

    public void delPersonne(Long id){
        personneRepository.delete(getPersonne(id));
    }
}
