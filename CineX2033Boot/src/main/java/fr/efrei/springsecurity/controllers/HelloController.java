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

    @Autowired
    UserRepository userRepository;


    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public String helloWorld() {
        return "hello world";
    }

    @PostMapping("users")
    public UserFormDao createUser(
            UserFormDao userFormDao
    ) {
        Role role = roleRepository.findByName(Role.ROLE_USER);
        createUserIfNotFound(userFormDao.getUsername(), passwordEncoder.encode(userFormDao.getPassword()), role);

        return userFormDao;
    }


    @Transactional
    Role createRoleIfNotFound(final String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role = roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    UserEntity createUserIfNotFound(final String name, final String password, final Role role) {
        UserEntity user = userRepository.findByUsername(name);
        if (user == null) {
            user = new UserEntity(name, password);
            user.setRoles(Set.of(role));
            user = userRepository.save(user);
        }

        return user;
    }

}
