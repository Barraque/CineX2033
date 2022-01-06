package models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="film_id",nullable = false,updatable = false)
    private Long film_id;

    @Column(name="titre",length = 100,nullable = false)
    private String titre;

    @Column(name="duree", nullable = false)
    private int duree;

    @Column(name="langues", nullable = false)
    private Langues langues;

    @Column(name="producteur", nullable = false)
    private Personne producteur;

    @Column(name="Listeacteurs", nullable = false)
    private List<Personne> Listeacteurs;

    @Column(name="minage", nullable = false)
    private int minage;

    @Column(name="dateD", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date dateD;

    @Column(name="dateF", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date dateF;


    public void setId(Long id) {
        this.film_id = id;
    }

    @Id
    public Long getId() {
        return film_id;
    }
}
