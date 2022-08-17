package com.cinema.project.service.impl;

import com.cinema.project.entities.SessionFilm;
import java.util.List;

public interface SessionFilmServiceImpl {
    List<SessionFilm> getAllSessionFilms();

    void saveOrUpdateSessionFilm(SessionFilm sessionFilm);

    SessionFilm getSessionFilm(long id);

    void deleteSessionFilm(long id);
}
