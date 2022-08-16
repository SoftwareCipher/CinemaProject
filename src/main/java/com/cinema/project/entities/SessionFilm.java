package com.cinema.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;


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
    @Column(name = "cinema")
    private LocalDateTime localDateTime;
    @Column(name = "cinema")
    private int price;
}
