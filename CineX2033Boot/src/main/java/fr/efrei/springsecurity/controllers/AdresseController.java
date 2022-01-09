package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Adresse;
import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.services.auth.AdresseService;
import fr.efrei.springsecurity.services.auth.CinemaService;
import fr.efrei.springsecurity.services.auth.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("adresse")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    FilmService filmService;

    @PostMapping("")
    public Adresse createAdresse(
            @RequestBody Adresse adresse
    ){
        return adresseService.saveAdresse(adresse);
    }

    @GetMapping("{id}")
    public Adresse getAdresse(
            @PathVariable(name = "id") Long id
    ){
        return adresseService.getAdresse(id);
    }

    @GetMapping("")
    public List<Adresse> getAllAdresse() {
        return adresseService.getallAdresse();
    }

    @GetMapping("ville={ville}/films")
    public List<Film> getFilmsFromVille(@PathVariable String ville){
        List<Cinema> cinemas = cinemaService.getCinemaFromVille(ville);
        List<Film> films = new ArrayList<Film>();
        for (Cinema cinema:cinemas) {
            for (Film film : cinema.getFilms()) {
                if(!films.contains(film)) {
                    films.add(film);
                }
            }
        }
        return films;
    }
}
