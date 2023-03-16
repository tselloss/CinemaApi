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
public class Tickets {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ticketId;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

    private boolean ticketStatus;

    @OneToOne
    private TicketsBooking booking;

    @OneToMany
    @JsonManagedReference
    private List<Seat> seat;

}
