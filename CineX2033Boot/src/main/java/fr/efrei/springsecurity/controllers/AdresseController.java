package fr.efrei.springsecurity.controllers;


import fr.efrei.springsecurity.models.Adresse;
import fr.efrei.springsecurity.models.Cinema;
import fr.efrei.springsecurity.services.auth.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adresse")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

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


}
