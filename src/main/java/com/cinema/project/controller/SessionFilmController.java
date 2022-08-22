package com.cinema.project.controller;

import com.cinema.project.entities.SessionFilm;
import com.cinema.project.service.impl.SessionFilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("session")
public class SessionFilmController {
    private SessionFilmServiceImpl service;

    @Autowired
    public SessionFilmController(SessionFilmServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/sessions")
    public List<SessionFilm> getSessions() {
        return service.getAllSessionFilms();
    }

    @GetMapping("/session/{id}")
    public SessionFilm getSessionFilm(@PathVariable long id) {
        return service.getSessionFilm(id);
    }

    @PostMapping("/session")
    public SessionFilm saveSession(@RequestBody SessionFilm sessionFilm) {
        service.saveOrUpdateSessionFilm(sessionFilm);
        return sessionFilm;
    }

    @DeleteMapping("/session/{id}")
    public void deleteSession(@PathVariable long id) {
        service.deleteSessionFilm(id);
    }
}
