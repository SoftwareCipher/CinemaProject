package com.cinema.project.service;

import com.cinema.project.entities.Cinema;
import com.cinema.project.repository.CinemaRepository;
import com.cinema.project.service.impl.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
class CinemaService implements CinemaServiceImpl {

    CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema saveOrUpdateCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema getCinema(long id) {
        Cinema cinema = null;
        Optional<Cinema> optional = cinemaRepository.findById(id);
        if(optional.isPresent()){
            cinema = optional.get();
        }else{
            System.out.println("Error! Cinema " + id + " not found!");
        }
        return cinema;
    }

    @Override
    public void deleteCinema(long id) {
        cinemaRepository.deleteById(id);
    }
}
