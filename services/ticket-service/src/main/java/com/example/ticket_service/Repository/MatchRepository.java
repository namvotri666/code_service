package com.example.ticket_service.Repository;

import com.example.ticket_service.Model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
