package fr.efrei.springsecurity.services;


import fr.efrei.springsecurity.exceptions.BadReqException;
import fr.efrei.springsecurity.exceptions.GlobalException;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.Personne;
import fr.efrei.springsecurity.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;


    public Film saveFilm(Film film) throws BadReqException {
        film = proccesPersonne(film);
        return filmRepository.save(film);
    }

    public Film getFilm(Long id){
        Optional<Film> film = filmRepository.findById(id);
        return film.get();
    }

    public List<Film> getallFilm(){
        return filmRepository.findAll();
    }

    public void delFilm(Long id){
        filmRepository.delete(getFilm(id));
    }

    public Film proccesPersonne(Film film) throws BadReqException {
        ArrayList<Personne> acteurs = new ArrayList<>();
        for (Personne acteur: film.getActeurs()){
            if((acteur.isEstActeur()) && !acteurs.contains(acteur)){
                acteurs.add(acteur);
            }
        }
        film.setActeurs(acteurs);
        if(!film.getProducteur().isEstProducteur() || acteurs.size() == 0 ){
            throw new BadReqException();
        }
        return film;
    }
}
