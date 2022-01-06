package models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

public class Personne {

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
