package fr.efrei.springsecurity.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seance_id",nullable = false,updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn (name = "film_id")
    private Film film;

    @OneToOne
    @JoinColumn (name = "cinema_id")
    private Cinema cinema;

    @Column (name ="date_debut", nullable = false)
    private Date dateD;

    @Column (name ="date_fin", nullable = false)
    private Date finD;
}
