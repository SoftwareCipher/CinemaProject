package com.cinema.project.service;

import com.cinema.project.entities.SessionFilm;
import com.cinema.project.repository.SessionFilmRepository;
import com.cinema.project.service.impl.SessionFilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SessionFilmService implements SessionFilmServiceImpl {

    private SessionFilmRepository sessionFilmRepository;

    @Autowired
    public SessionFilmService(SessionFilmRepository sessionFilmRepository) {
        this.sessionFilmRepository = sessionFilmRepository;
    }

    @Override
    public List<SessionFilm> getAllSessionFilms() {
        return sessionFilmRepository.findAll();
    }

    @Override
    public SessionFilm saveOrUpdateSessionFilm(SessionFilm sessionFilm) {
        return sessionFilmRepository.save(sessionFilm);
    }

    @Override
    public SessionFilm getSessionFilm(long id) {
        return sessionFilmRepository.getById(id);
    }

    @Override
    public void deleteSessionFilm(long id) {
        sessionFilmRepository.deleteById(id);
    }
}
