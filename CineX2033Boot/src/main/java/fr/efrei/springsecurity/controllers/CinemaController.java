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
    public Cinema getFilm(
            @PathVariable(name = "id") Long id
    ){
        return cinemaService.getCinema(id);
    }

    @GetMapping("")
    public List<Cinema> getAllCinema() {
        return cinemaService.getallCinema();
    }


}
