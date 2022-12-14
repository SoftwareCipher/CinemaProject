package com.cinema.project.service.impl;

import com.cinema.project.entities.Ticket;
import java.util.List;

public interface TicketServiceImpl {
    List<Ticket> getAllTickets();

    Ticket saveOrUpdateTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    Ticket getTicket(long id);

    void deleteTicket(long id);

    Ticket seatOccupiedOrNo(int place);
}
