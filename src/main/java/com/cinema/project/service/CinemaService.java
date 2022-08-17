package com.cinema.project.service;

import com.cinema.project.entities.Cinema;
import com.cinema.project.repository.CinemaRepository;
import com.cinema.project.service.impl.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class CinemaService implements CinemaServiceImpl {

    CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return null;
    }

    @Override
    public void saveOrUpdateCinema(Cinema cinema) {

    }

    @Override
    public Cinema getCinema(long id) {
        return null;
    }

    @Override
    public void deleteCinema(long id) {

    }
}
