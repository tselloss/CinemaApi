package com.example.cinemaapp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany
    @JsonManagedReference
    private List<Tickets> ticket;

    @ManyToOne
    @JsonBackReference
    private Movie movie;

}
