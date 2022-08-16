package com.cinema.project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_code")
    private Long paymentCode;
    @Column(name = "summa")
    private int summa;
    @Column(name = "card")
    private Long card;
    @Column(name = "status")
    private String status;
}
