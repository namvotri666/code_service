package com.example.ticket_service.Config;

import com.example.ticket_service.Model.Match;
import com.example.ticket_service.Model.Ticket;
import com.example.ticket_service.Repository.MatchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(MatchRepository matchRepo) {
        return args -> {

            // 🔥 tương đương WHERE NOT EXISTS
            if (!matchRepo.existsById(1)) {

                // ===== MATCH =====
                Match match = new Match();
                match.setMatchName("MU vs Chelsea");

                // ===== TICKET =====
                Ticket t1 = new Ticket();
                t1.setStandsDetail("A1");
                t1.setPrice(100);
                t1.setMatch(match);

                Ticket t2 = new Ticket();
                t2.setStandsDetail("B1");
                t2.setPrice(80);
                t2.setMatch(match);
                match.setTickets(List.of(t1, t2));
                // save match → ticket tự save (cascade)
                matchRepo.save(match);
            }
        };
    }
}
