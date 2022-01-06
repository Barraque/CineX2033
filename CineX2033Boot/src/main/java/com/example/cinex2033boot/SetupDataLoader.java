package com.example.cinex2033boot;

import com.example.cinex2033boot.Models.Role;
import com.example.cinex2033boot.Models.UserEntity;
import com.example.cinex2033boot.Repositories.RoleRepository;
import com.example.cinex2033boot.Repositories.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // Create user roles
        var userRole = createRoleIfNotFound(Role.ROLE_USER);
        var adminRole = createRoleIfNotFound(Role.ROLE_ADMIN);

        // Create users
        createUserIfNotFound("user", userRole);
        createUserIfNotFound("admin", adminRole);

        alreadySetup = true;
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
    UserEntity createUserIfNotFound(final String name, final Role role) {
        UserEntity user = userRepository.findByUsername(name);
        if (user == null) {
            user = new UserEntity(name, "$2y$10$3mMCWaxZYx1xDLMAfyIOyuuZ8wTKBTaWei2oAUKYHI9InFHzvoht6");
            HashSet<Role> se = new HashSet();
            se.add(role);
            user.setRoles(se);
            user = userRepository.save(user);
        }
        return user;
    }
}