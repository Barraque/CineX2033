package fr.efrei.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Film {

    @Column(name = "name")
    private String nom;

    @Column(name = "annee")
    private int annee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="film_id",nullable = false,updatable = false)
    private Long id;

    public Film(String nom, int annee){
        this.annee = annee;
        this.nom = nom;
    }

}
