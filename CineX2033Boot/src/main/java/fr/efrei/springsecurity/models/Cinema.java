package fr.efrei.springsecurity.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table
@Entity

public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cinema_id",nullable = false,updatable = false)
    private Long cinema_id;

    @OneToOne
    private Adresse adresse;

    @ManyToMany
    private List<Films> films;

    @Column(nullable = false)
    private String nom;


}
