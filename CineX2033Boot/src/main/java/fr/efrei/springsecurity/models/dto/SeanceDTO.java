package fr.efrei.springsecurity.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SeanceDTO {

    private Long id;

    private Long FilmId;

    private Long CinemaId;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateD;

}
