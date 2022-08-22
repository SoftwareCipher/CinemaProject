package com.cinema.project.service;

import com.cinema.project.entities.Film;
import com.cinema.project.repository.FilmRepository;
import com.cinema.project.service.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        Film film = null;
        Optional<Film> optional = repository.findById(id);
        if(optional.isPresent()){
            film = optional.get();
        }else{
            System.out.println("Error! Film " + id + " not found!");
        }
        return film;
    }

    @Override
    public void deleteFilm(long id) {
        repository.deleteById(id);
    }
}
