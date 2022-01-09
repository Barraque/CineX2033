package fr.efrei.springsecurity.services;

import fr.efrei.springsecurity.models.Adresse;
import fr.efrei.springsecurity.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {

    @Autowired
    AdresseRepository adresseRepository;

    public Adresse saveAdresse(final Adresse adresse){

        return adresseRepository.save(adresse);
    }

    public Adresse getAdresse(Long id){
        Optional<Adresse> adresse = adresseRepository.findById(id);
        return adresse.get();
    }

    public List<Adresse> getallAdresse(){
        return adresseRepository.findAll();
    }

}
