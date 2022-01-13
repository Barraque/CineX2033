package fr.efrei.springsecurity.services;


import fr.efrei.springsecurity.models.Seance;
import fr.efrei.springsecurity.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {


    @Autowired
    SeanceRepository seanceRepository;

    public Seance saveSeance(final Seance seance){
        return seanceRepository.save(seance);
    }

    public Seance getSeance(Long id){
        Optional<Seance> seance = seanceRepository.findById(id);
        return seance.get();
    }

    public List<Seance> getAllSeance(){
        return seanceRepository.findAll();
    }

    public void delSeance(Long id){
        seanceRepository.delete(getSeance(id));
    }


}
