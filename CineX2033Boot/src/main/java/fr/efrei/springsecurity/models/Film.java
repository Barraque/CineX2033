package fr.efrei.springsecurity.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Film {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id",nullable = false,updatable = false)
    private Long film_id;

    @Column(name="titre",length = 100,nullable = false)
    private String titre;

    @Column(name="duree", nullable = false)
    private int duree;

    @Column(name="langues", nullable = false)
    private Langue_film langues;

    @ManyToOne
    @JoinColumn (name = "personne_id")
    private Personne producteur;

    @ManyToMany
    @JoinColumn (name = "personne_id")
    private List<Personne> acteurs;

    @Column(name="minage", nullable = false)
    private int minage;

    @Column(name="dateD", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateD;

    @Column(name="dateF", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateF;

}
