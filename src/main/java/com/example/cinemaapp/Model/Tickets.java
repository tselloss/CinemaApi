package com.example.cinemaapp.Model;

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

    private int noOfSeats;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ticket_id", referencedColumnName = "ticketId")
    private List<Seat> seatNumber;

    private boolean ticketStatus;

    @OneToOne
    private TicketsBooking booking;

}
