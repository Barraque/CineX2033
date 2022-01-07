package models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity

public class Adresse {

    @Column(nullable = false)
    private String rue;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String codepostal;
    @Column(nullable = false)
    private String pays;

}
