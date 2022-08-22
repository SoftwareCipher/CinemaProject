package com.cinema.project.controller;

import com.cinema.project.entities.Cinema;
import com.cinema.project.service.impl.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    CinemaServiceImpl cinemaService;

    @Autowired
    public CinemaController(CinemaServiceImpl cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinemas")
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @PostMapping("/cinema")
    public Cinema saveOrUpdateCinema(@RequestBody Cinema cinema) {
        cinemaService.saveOrUpdateCinema(cinema);
        return cinema;
    }

    @GetMapping("/cinema/{id}")
    public Cinema getCinema(@PathVariable long id) {
        return cinemaService.getCinema(id);
    }

    @DeleteMapping("/cinema/{id}")
    public void deleteCinema(@PathVariable long id) {
        cinemaService.deleteCinema(id);
    }
}
