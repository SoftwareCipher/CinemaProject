package com.cinema.project.controller;

import com.cinema.project.entities.Ticket;
import com.cinema.project.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketServiceImpl ticketService;

    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket")
    public Ticket getTicket(@PathVariable long id) {
        return ticketService.getTicket(id);
    }

    @PostMapping("/ticket")
    public Ticket saveTicket(@RequestBody Ticket ticket) {
        return ticketService.saveOrUpdateTicket(ticket);
    }

    @DeleteMapping("/ticket")
    public void deleteTicket(@PathVariable long id) {
        ticketService.deleteTicket(id);
    }
}
