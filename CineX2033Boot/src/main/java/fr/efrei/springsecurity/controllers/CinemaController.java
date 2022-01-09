package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.dto.CinemaDTO;
import fr.efrei.springsecurity.services.CinemaService;
import fr.efrei.springsecurity.services.FilmService;
import fr.efrei.springsecurity.services.TransitionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cinemas")

public class CinemaController {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    TransitionDTO transitionDTO;

    @Autowired
    FilmService filmService;

    @PostMapping("")
    public Cinema createCinema(
            @RequestBody CinemaDTO cinemaDTO
    ){
        return cinemaService.saveCinema(transitionDTO.fromDto(cinemaDTO));
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

    @PostMapping("{id}/film/{filmId}")
    public Cinema addFilmToCinema(
            @PathVariable(name= "id") Long id,
            @PathVariable(name= "filmId") Long filmId
    ){
        Cinema cinema = getCinema(id);
        Film film = filmService.getFilm(filmId);
        if(!cinema.getFilms().contains(film))
            cinema.getFilms().add(film);
        return cinemaService.saveCinema(cinema);

    }



}
