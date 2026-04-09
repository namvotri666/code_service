package com.example.ticket_service.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "matches")
@Getter
@Setter
public class Match {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "match_name")
    private String matchName;
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public String getMatchName() {
        return matchName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
