package com.cinema.project.repository;

import com.cinema.project.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select p from Ticket p where p.place = ?1")
    Ticket seatOccupiedOrNo(int place);
}
