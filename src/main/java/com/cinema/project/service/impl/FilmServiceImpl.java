package com.cinema.project.service.impl;

import com.cinema.project.entities.Film;
import java.util.List;

public interface FilmServiceImpl {
    List<Film> getAllFilms();

    Film saveOrUpdateFilm(Film film);

    Film getFilm(long id);

    void deleteFilm(long id);
}
