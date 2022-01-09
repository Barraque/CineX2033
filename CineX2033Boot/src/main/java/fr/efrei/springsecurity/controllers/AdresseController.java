package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Adresse;
import fr.efrei.springsecurity.services.AdresseService;
import fr.efrei.springsecurity.services.CinemaService;
import fr.efrei.springsecurity.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adresses")
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

    @PutMapping
    public Adresse changeAdresse(
            @RequestBody Adresse adresse
    ){
        return adresseService.saveAdresse(adresse);
    }
}
