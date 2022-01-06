package fr.efrei.springsecurity.services.auth;

import fr.efrei.springsecurity.models.auth.Role;
import fr.efrei.springsecurity.models.auth.UserEntity;
import fr.efrei.springsecurity.models.auth.UserFormDao;
import fr.efrei.springsecurity.repositories.RoleRepository;
import fr.efrei.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void addUser(UserFormDao userFormDao){
        Role role = roleRepository.findByName(Role.ROLE_USER);
        createUserIfNotFound(userFormDao.getUsername(), passwordEncoder.encode(userFormDao.getPassword()), role);
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
