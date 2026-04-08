package com.example.ticket_service.Controller;

import com.example.ticket_service.Model.Ticket;
import com.example.ticket_service.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TicketController {
    @Autowired
    private TicketService ticketService;
    @GetMapping("/ticket/get")
    public List<Ticket> getAllTicket(){
        return ticketService.getTickets();
    }
}
