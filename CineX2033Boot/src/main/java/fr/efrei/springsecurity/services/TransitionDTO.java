package fr.efrei.springsecurity.services;

import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.Personne;
import fr.efrei.springsecurity.models.Seance;
import fr.efrei.springsecurity.models.dto.CinemaDTO;
import fr.efrei.springsecurity.models.dto.FilmDTO;
import fr.efrei.springsecurity.models.dto.SeanceDTO;
import fr.efrei.springsecurity.repositories.AdresseRepository;
import fr.efrei.springsecurity.repositories.CinemaRepository;
import fr.efrei.springsecurity.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransitionDTO {

    @Autowired
    CinemaService cinemaService;
    @Autowired
    FilmService filmService;
    @Autowired
    AdresseService adresseService;
    @Autowired
    PersonneService personneService;

    public Cinema fromDto(CinemaDTO cinemaDTO){
        Cinema cinema = new Cinema();
        cinema.setCinema_id(cinemaDTO.getId());
        cinema.setNom(cinemaDTO.getNom());
        cinema.setAdresse(adresseService.getAdresse(cinemaDTO.getAdresseId()));
        List<Film> films = new ArrayList<>();
        for (Long id:cinemaDTO.getListefilm()) {
            films.add(filmService.getFilm(id));
        }
        cinema.setFilms(films);
        return cinema;
    }

    public Film fromDto(FilmDTO filmDTO){
        Film film = new Film();
        film.setFilm_id(filmDTO.getId());
        film.setTitre(filmDTO.getTitre());
        film.setDuree(filmDTO.getDuree());
        film.setLangues(filmDTO.getLangues());
        film.setDateD(filmDTO.getDateD());
        film.setDateF(filmDTO.getDateF());
        film.setMinage(filmDTO.getMinage());
        film.setImgurl(filmDTO.getImgurl());
        film.setProducteur(personneService.getPersonne(filmDTO.getProducteurId()));
        List<Personne> acteurs = new ArrayList<>();
        for (Long id: filmDTO.getActeurs()) {
            acteurs.add(personneService.getPersonne(id));
        }
        film.setActeurs(acteurs);
        return film;
    }

    public Seance fromDto(SeanceDTO seanceDTO){
        Seance seance = new Seance();
        seance.setId(seanceDTO.getId());
        seance.setCinema(cinemaService.getCinema(seanceDTO.getCinemaId()));
        seance.setFilm(filmService.getFilm(seanceDTO.getFilmId()));
        seance.setDateD(seanceDTO.getDateD());
        return seance;
    }
}
