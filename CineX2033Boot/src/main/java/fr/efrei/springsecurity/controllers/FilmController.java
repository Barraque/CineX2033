package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.services.auth.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("")
    public Film createFilm(
            @RequestBody Film film
    ){
        return filmService.saveFilm(film);
    }

    @GetMapping("{id}")
    public Film getFilm(
            @PathVariable(name = "id") long id
    ){
        return filmService.getFilm(id);
    }
}
