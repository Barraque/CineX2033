package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.models.Film;
import fr.efrei.springsecurity.models.dto.FilmDTO;
import fr.efrei.springsecurity.services.CinemaService;
import fr.efrei.springsecurity.services.FilmService;
import fr.efrei.springsecurity.services.TransitionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("films")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FilmController {

    @Autowired
    FilmService filmService;
    @Autowired
    TransitionDTO transitionDTO;
    @Autowired
    CinemaService cinemaService;

    @PostMapping("")
    public Film createFilm(
            @RequestBody FilmDTO filmDTO
    ){
        return filmService.saveFilm(transitionDTO.fromDto(filmDTO));
    }

    @GetMapping("{id}")
    public Film getFilm(
            @PathVariable(name = "id") Long id
    ){
        return filmService.getFilm(id);
    }
    @GetMapping("")
    public List<Film> getAllFilm(
            @RequestParam(required = false) Optional<String> ville
    ) {
       if(ville.isPresent()){
           List<Cinema> cinemas = cinemaService.getCinemaFromVille(ville.get());
           List<Film> films = new ArrayList<>();
           for (Cinema cinema:cinemas) {
               for (Film film : cinema.getFilms()) {
                   if(!films.contains(film)) {
                       films.add(film);
                   }
               }
           }
           return films;
       }
       return filmService.getallFilm();
    }

    @PutMapping
    public Film changeFilm(
            @RequestBody FilmDTO filmDTO
    ){
        return filmService.saveFilm(transitionDTO.fromDto(filmDTO));
    }

}
