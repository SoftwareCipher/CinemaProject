package com.cinema.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "email")
    private String email;
    @Column(name = "card")
    private Long card;
    @Column(name = "phone")
    private Long phone;
}
