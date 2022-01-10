package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.Seance;
import fr.efrei.springsecurity.models.dto.SeanceDTO;
import fr.efrei.springsecurity.services.SeanceService;
import fr.efrei.springsecurity.services.TransitionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seances")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SeanceController {

    @Autowired
    SeanceService seanceService;

    @Autowired
    TransitionDTO transitionDTO;

    @PostMapping("")
    public Seance createSeance(
            @RequestBody SeanceDTO seanceDTO
    ){
        return seanceService.saveSeance(transitionDTO.fromDto(seanceDTO));
    }

    @GetMapping("{id}")
    public Seance getSeance(
            @PathVariable(name = "id") Long id
    ){
        return seanceService.getSeance(id);
    }

    @GetMapping("")
    public List<Seance> getAllSeance() {
        return seanceService.getAllSeance();
    }

    @PutMapping
    public Seance changeSeance(
            @RequestBody SeanceDTO seanceDTO
    ){
        return seanceService.saveSeance(transitionDTO.fromDto(seanceDTO));
    }
    
}
