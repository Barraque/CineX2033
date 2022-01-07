package fr.efrei.springsecurity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="adresse_id",nullable = false,updatable = false)
    private Long adresse_id;

    @Column(nullable = false)
    private String rue;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String codepostal;
    @Column(nullable = false)
    private String pays;

}
