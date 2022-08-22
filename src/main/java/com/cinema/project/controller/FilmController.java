package com.cinema.project.controller;

import com.cinema.project.entities.Film;
import com.cinema.project.service.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    private FilmServiceImpl filmService;

    @Autowired
    public FilmController(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @PostMapping("/film")
    public Film saveOrUpdateFilm(@RequestBody Film film) {
        return filmService.saveOrUpdateFilm(film);
    }

    @GetMapping("/film/{id}")
    public Film getFilm(@PathVariable long id) {
        return filmService.getFilm(id);
    }

    @DeleteMapping("/film/{id}")
    public void deleteFilm(@PathVariable long id) {
        filmService.deleteFilm(id);
    }
}
