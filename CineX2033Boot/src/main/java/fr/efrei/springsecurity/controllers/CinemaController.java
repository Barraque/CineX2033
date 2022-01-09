package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.services.auth.CinemaService;
import fr.efrei.springsecurity.services.auth.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cinema")

public class CinemaController {
    @Autowired
    CinemaService cinemaService;

    @PostMapping("")
    public Cinema createCinema(
            @RequestBody Cinema cinema
    ){
        return cinemaService.saveCinema(cinema);
    }

    @GetMapping("{id}")
    public Cinema getCinema(
            @PathVariable(name = "id") Long id
    ){
        return cinemaService.getCinema(id);
    }

    @GetMapping("")
    public List<Cinema> getAllCinema() {
        return cinemaService.getallCinema();
    }

    @GetMapping("{id}/films")
    public List<Film> getFilmFromACinema(
            @PathVariable(name = "id") Long id){
        return getCinema(id).getFilms();
    }

    @PostMapping("{id}/films")
    public Cinema addFilmToCinema(
            @PathVariable(name= "id") Long id,
            @RequestBody Film film
    ){
        Cinema cinema = getCinema(id);
        if(!cinema.getFilms().contains(film))
            cinema.getFilms().add(film);
        return cinemaService.saveCinema(cinema);

    }

}
