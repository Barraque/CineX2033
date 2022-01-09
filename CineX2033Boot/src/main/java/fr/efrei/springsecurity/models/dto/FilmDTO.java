package fr.efrei.springsecurity.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.efrei.springsecurity.models.Langue_film;
import fr.efrei.springsecurity.models.Personne;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
@Data
public class FilmDTO {

    private String titre;

    private int duree;

    private Langue_film langues;

    private Personne producteur;

    private List<Long> acteurs;

    private int minage;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateD;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateF;

    private String imgurl;

}
