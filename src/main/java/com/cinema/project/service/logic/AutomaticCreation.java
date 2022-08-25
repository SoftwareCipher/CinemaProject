package com.cinema.project.service.logic;

import com.cinema.project.entities.Pay;
import com.cinema.project.entities.Ticket;
import com.cinema.project.service.PayService;
import com.cinema.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomaticCreation {
    TicketService ticketService;
    PayService payService;

    @Autowired
    public AutomaticCreation(TicketService ticketService, PayService payService) {
        this.ticketService = ticketService;
        this.payService = payService;
    }

    @Scheduled(fixedRate = 2000)
    public void createTicket() {
        List<Ticket> ticketList = ticketService.getAllTickets();
        for (int i = 0; i < ticketList.size(); i++) {
            Ticket ticket = ticketList.get(i);
            if (ticket.getStatus().equals("New")) {
                Pay pay = createPayment();
                payService.saveOrUpdatePay(pay);
                ticket.setPaymentCode(pay.getPaymentCode());
                ticket.setStatus("Making a payment");
                ticketService.updateTicket(ticket);
            }
        }
    }

    public Pay createPayment() {
        Pay pay = new Pay();
        pay.setSumma(200);
        pay.setCard(12345346L);
        pay.setStatus("new");
        return pay;
    }
}
