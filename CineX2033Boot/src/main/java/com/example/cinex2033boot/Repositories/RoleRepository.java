package com.example.cinex2033boot.Repositories;

import com.example.cinex2033boot.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}