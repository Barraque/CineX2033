package fr.efrei.springsecurity.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SeanceDTO {

    private Long id;

    private Long FilmId;

    private Long CinemaId;

    private Date dateD;

    private Date dateF;
}
