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
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "session_film_id")
    private Long sessionFilmId;
    @Column(name = "row")
    private int row;
    @Column(name = "place")
    private int place;
    @Column(name = "person")
    private Long person;
    @Column(name = "status")
    private String status;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @Column(name = "date_change")
    private LocalDateTime dateChange;
    @Column(name = "payment_code")
    private Long paymentCode;
}
