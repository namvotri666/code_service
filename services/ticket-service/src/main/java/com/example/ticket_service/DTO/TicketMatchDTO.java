package com.example.ticket_service.DTO;


import lombok.Data;

@Data
public class TicketMatchDTO {
    private Double price;
    private String standsDetail;
    private String matchName;

    public TicketMatchDTO(Double price, String standsDetail, String matchName) {
        this.price = price;
        this.standsDetail = standsDetail;
        this.matchName = matchName;
    }
}
