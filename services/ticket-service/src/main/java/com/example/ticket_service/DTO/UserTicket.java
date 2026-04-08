package com.example.ticket_service.DTO;

import lombok.Data;

@Data
public class UserTicket {
    private String standsDetail;
    private double price;
    private String matchName;

    public UserTicket(String standsDetail, double price, String matchName) {
        this.standsDetail = standsDetail;
        this.price = price;
        this.matchName = matchName;
    }
}
