package fr.efrei.springsecurity.repositories;

import fr.efrei.springsecurity.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
