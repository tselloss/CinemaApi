package com.example.cinemaapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TicketsBooking {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int bookingId;

    private String bookingDate;
    private int transactionId;
    private String transactionMode;
    private String transactionStatus;
    private double totalCost;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Tickets ticket;

}
