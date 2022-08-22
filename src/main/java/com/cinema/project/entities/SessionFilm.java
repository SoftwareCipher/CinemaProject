package com.cinema.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "session_film")
public class SessionFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "film")
    private Long film;
    @Column(name = "cinema")
    private Long cinema;
    @Column(name = "time")
    private String time;
    @Column(name = "price")
    private int price;
}
