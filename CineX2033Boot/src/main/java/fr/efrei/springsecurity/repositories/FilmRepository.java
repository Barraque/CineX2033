package fr.efrei.springsecurity.repositories;

import fr.efrei.springsecurity.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository  extends JpaRepository<Film, Long> {
}
