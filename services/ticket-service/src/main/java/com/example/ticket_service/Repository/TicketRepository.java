package com.example.ticket_service.Repository;

import com.example.ticket_service.DTO.TicketMatchDTO;
import com.example.ticket_service.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("""
    SELECT new com.example.ticket_service.DTO.TicketMatchDTO(
        t.price,
        t.standsDetail,
        m.matchName
    )
    FROM Ticket t
    JOIN t.match m
""")
    List<TicketMatchDTO> getTicketAndMatch();

}
