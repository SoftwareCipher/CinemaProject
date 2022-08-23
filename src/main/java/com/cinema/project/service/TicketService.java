package com.cinema.project.service;

import com.cinema.project.entities.Ticket;
import com.cinema.project.repository.TicketRepository;
import com.cinema.project.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        ticket.setDateChange(LocalDateTime.now());
        ticket.setDateCreation(LocalDateTime.now());
        ticket.setStatus("New");
        if(seatOccupiedOrNo(ticket.getPlace()) != null){
            System.out.println("Error! This Place is busy");
        }else{
            return ticketRepository.save(ticket);
        }
        return null;
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticket.setDateChange(LocalDateTime.now());
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(long id) {
        Ticket ticket = null;
        Optional<Ticket> optional = ticketRepository.findById(id);
        if (optional.isPresent()) {
            ticket = optional.get();
        } else {
            System.out.println("Error! Ticket " + id + " not found!");
        }
        return ticket;
    }

    @Override
    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket seatOccupiedOrNo(int place) {
        return ticketRepository.seatOccupiedOrNo(place);
    }
}
