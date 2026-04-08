package com.example.ticket_service.Service;

import com.example.ticket_service.Model.Match;
import com.example.ticket_service.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    public List<Match> getAllMatch(){
        return matchRepository.findAll();
    }

}
