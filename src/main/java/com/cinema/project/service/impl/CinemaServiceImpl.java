package com.cinema.project.service.impl;

import com.cinema.project.entities.Cinema;
import java.util.List;

public interface CinemaServiceImpl {
    List<Cinema> getAllCinemas();

    void saveOrUpdateCinema(Cinema cinema);

    Cinema getCinema(long id);

    void deleteCinema(long id);
}
