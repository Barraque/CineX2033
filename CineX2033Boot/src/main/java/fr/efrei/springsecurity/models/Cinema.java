package fr.efrei.springsecurity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cinema_id",nullable = false,updatable = false)
    private Long cinema_id;

    @OneToOne
    @JoinColumn (name = "adresse_id")
    private Adresse adresse;

    @ManyToMany
    @JoinColumn (name = "film_id")
    private List<Film> films;

    @Column(nullable = false)
    private String nom;


}
