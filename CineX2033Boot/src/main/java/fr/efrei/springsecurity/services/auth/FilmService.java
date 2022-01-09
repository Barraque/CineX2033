package fr.efrei.springsecurity.services.auth;


import fr.efrei.springsecurity.exceptions.GlobalException;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.repositories.CinemaRepository;
import fr.efrei.springsecurity.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;


    public Film saveFilm(final Film film){

        return filmRepository.save(film);
    }

    public Film getFilm(Long id){
        Optional<Film> film = filmRepository.findById(id);
        return film.get();
    }

    public List<Film> getallFilm(){
        return filmRepository.findAll();
    }

}
