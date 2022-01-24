package fr.efrei.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column (name ="date_debut", nullable = false)
    private Date dateD;

}
