package fr.efrei.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="personne_id",nullable = false,updatable = false)
    private Long personne_id;

    @Column(name="prenom",length = 100,nullable = false)
    private String prenom;

    @Column(name="nom",length = 100,nullable = false)
    private String nom;

    @Column(name="daten", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyy")
    private Date daten;

    @Column(name="titre", nullable = false)
    private boolean estActeur;

    @Column(name="titre", nullable = false)
    private boolean estProducteur;
}
