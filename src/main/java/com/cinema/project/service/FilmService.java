package com.cinema.project.service;

import com.cinema.project.entities.Film;
import com.cinema.project.repository.FilmRepository;
import com.cinema.project.service.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class FilmService implements FilmServiceImpl {

    private FilmRepository repository;

    @Autowired
    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> getAllFilms() {
        return repository.findAll();
    }

    @Override
    public Film saveOrUpdateFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public Film getFilm(long id) {
        return repository.getById(id);
    }

    @Override
    public void deleteFilm(long id) {
        repository.deleteById(id);
    }
}
