package com.cinema.project.service;

import com.cinema.project.entities.Ticket;
import com.cinema.project.repository.TicketRepository;
import com.cinema.project.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService implements TicketServiceImpl {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket saveOrUpdateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(long id) {
        return ticketRepository.getById(id);
    }

    @Override
    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
}
