package fr.efrei.springsecurity.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserFormDao {
    private String username;
    private String password;
}