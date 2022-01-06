package fr.efrei.springsecurity.controllers;

import fr.efrei.springsecurity.models.auth.Role;
import fr.efrei.springsecurity.models.auth.UserEntity;
import fr.efrei.springsecurity.models.auth.UserFormDao;
import fr.efrei.springsecurity.repositories.RoleRepository;
import fr.efrei.springsecurity.repositories.UserRepository;
import fr.efrei.springsecurity.services.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("auth")
    public String helloAuth() {
        return "hello auth";
    }


}
