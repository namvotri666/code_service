package com.example.ticket_service.Controller;

import com.example.ticket_service.Model.Match;
import com.example.ticket_service.Repository.MatchRepository;
import com.example.ticket_service.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;
    @GetMapping("/match/get")
    public List<Match> getAllMatch(){
        return matchService.getAllMatch();
    }

}
