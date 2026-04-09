package com.example.ticket_service.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "stands_detail")
    private String standsDetail;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "match_id")
    @JsonBackReference
    private Match match;

    public int getId() {
        return id;
    }

    public String getStandsDetail() {
        return standsDetail;
    }

    public double getPrice() {
        return price;
    }

    public Match getMatch() {
        return match;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void setStandsDetail(String standsDetail) {
        this.standsDetail = standsDetail;
    }
}
