package com.cinema.project.repository;

import com.cinema.project.entities.SessionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionFilmRepository extends JpaRepository<SessionFilm, Long> {
}
