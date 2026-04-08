package com.example.ticket_service.Service;

import com.example.ticket_service.DTO.UserTicket;
import com.example.ticket_service.Model.Ticket;
import com.example.ticket_service.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

}
