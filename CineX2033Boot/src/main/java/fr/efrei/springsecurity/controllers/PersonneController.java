package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.Personne;
import fr.efrei.springsecurity.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("personnes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @PostMapping("")
    public Personne createPersonne(
            @RequestBody Personne personne
    ){
        return personneService.savePersonne(personne);
    }

    @GetMapping("{id}")
    public Personne getPersonne(
            @PathVariable(name = "id") Long id
    ){
        return personneService.getPersonne(id);
    }

    @GetMapping("")
    public List<Personne> getAllPersonne() {
        return personneService.getallPersonne();
    }

    @PutMapping
    public Personne changePersonne(
        @RequestBody Personne personne
    ){
        return personneService.savePersonne(personne);
    }

    @DeleteMapping("{id}")
    public String delPersonne(
            @PathVariable("id") Long id
    ){
        personneService.delPersonne(id);
        return "Objet supprimé";
    }


}
