package fr.efrei.springsecurity.services;


import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.Seance;
import fr.efrei.springsecurity.models.dto.CinemaDTO;
import fr.efrei.springsecurity.repositories.CinemaRepository;
import fr.efrei.springsecurity.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    SeanceRepository seanceRepository;

    public Cinema saveCinema(final Cinema cinema){

        return cinemaRepository.save(cinema);
    }

    public Cinema getCinema(Long id){
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        return cinema.get();
    }

    public List<Cinema> getallCinema(){
        return cinemaRepository.findAll();
    }

    public List<Cinema> getCinemaFromVille(String ville){
        List<Cinema> cinemas = getallCinema();
        List<Cinema> cinemadeville = new ArrayList<Cinema>();
        for (Cinema cinema: cinemas) {
            if(cinema.getAdresse().getVille().equals(ville)){
                cinemadeville.add(cinema);
            }
        }
        return cinemadeville;
    }

    public void delCinema(Long id){
        cinemaRepository.delete(getCinema(id));
    }

    public List<Seance> getSeances(Long id) {
        List<Seance> seances = new ArrayList<>();
        for(Seance seance : seanceRepository.findAll()){
            if(seance.getCinema().getCinema_id().equals(id))
                seances.add(seance);
        }
        return seances;
    }
}
