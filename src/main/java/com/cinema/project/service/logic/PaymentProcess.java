package com.cinema.project.service.logic;

import com.cinema.project.entities.Pay;
import com.cinema.project.entities.Ticket;
import com.cinema.project.service.PayService;
import com.cinema.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PaymentProcess {
    TicketService ticketService;
    PayService payService;
    private long numberPay = 1;
    private long numberTicket = 1;

    @Autowired
    public PaymentProcess(TicketService ticketService,
                          PayService payService) {
        this.ticketService = ticketService;
        this.payService = payService;
    }

    @Scheduled(fixedRate = 5000)
    public void checkNewPayment() {
        List<Pay> payList = payService.getAllPays();
        for (long i = numberPay; i <= payList.size(); i++) {
            Pay pay = payService.getPay(i);
            if (pay.getStatus().equals("new")){
                String status = randomStatus();
                pay.setStatus(status);
                payService.saveOrUpdatePay(pay);
            }
            numberPay++;
        }
    }

    @Scheduled(fixedRate = 5000)
    public void ticketStatus() {
        List<Ticket> ticketList = ticketService.getAllTickets();
        for (long i = numberTicket; i <= ticketList.size(); i++) {
            Ticket ticket = ticketService.getTicket(i);
            Pay pay = payService.getPay(i);
            if (pay.getStatus().equals("paid")) {
                ticket.setStatus("Paid");
            }else{
                ticket.setStatus("Overdue");
            }
            numberTicket++;
            ticketService.updateTicket(ticket);
        }
    }

    private String randomStatus() {
        int number = randomNumber();
        String status;
        if(number == 1){
            status = "paid";
        }else{
            status = "overdue";
        }
        return status;
    }

    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
