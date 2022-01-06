package com.example.cinex2033boot.Models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;
}
