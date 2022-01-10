package fr.efrei.springsecurity.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class CinemaDTO {

    private Long id;

    private String nom;

    private List<Long> listefilm;

    private Long adresseId;
}
