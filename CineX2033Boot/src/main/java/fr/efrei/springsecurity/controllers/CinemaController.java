package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.Seance;
import fr.efrei.springsecurity.models.dto.CinemaDTO;
import fr.efrei.springsecurity.models.dto.FilmDTO;
import fr.efrei.springsecurity.services.CinemaService;
import fr.efrei.springsecurity.services.FilmService;
import fr.efrei.springsecurity.services.TransitionDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cinemas")
@CrossOrigin(origins = "*", maxAge = 3600)
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

    @PostMapping("{id}/films/{filmId}")
    public Cinema addFilmToCinema(
            @PathVariable(name= "id") Long id,
            @PathVariable(name= "filmId") Long filmId
    ){
        Cinema cinema = getCinema(id);
        Film film = filmService.getFilm(filmId);
       if(!cinemaService.getCinema(id).getFilms().contains(film)){
           cinemaService.getCinema(id).getFilms().add(film);
       }
        return cinemaService.saveCinema(cinema);
    }

    @DeleteMapping("{id}/films/{filmId}")
    public Cinema removeFilmToCinema(
                @PathVariable(name= "id") Long id,
                @PathVariable(name= "filmId") Long filmId
    ){
        Cinema cinema = getCinema(id);
        Film film = filmService.getFilm(filmId);
        List<Film> listeFilms = cinema.getFilms();
        if(listeFilms.contains(film)) {
            cinema.getFilms().remove(film);
        }
        return cinemaService.saveCinema(cinema);
    }

    @PutMapping
    public Cinema changeCinema(
            @RequestBody CinemaDTO cinemaDTO
    ){
        return cinemaService.saveCinema(transitionDTO.fromDto(cinemaDTO));
    }

    @DeleteMapping("{id}")
    public String delCinema(
            @PathVariable("id") Long id
    ){
        cinemaService.delCinema(id);
        return "Objet supprimé";
    }
    @GetMapping("{id}/seances")
    public List<Seance> getSeanceFromACinema(
            @PathVariable Long id
    ){
        return cinemaService.getSeances(id);
    }

}
