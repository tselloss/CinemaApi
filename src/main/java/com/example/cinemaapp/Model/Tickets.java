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

    @ManyToOne
    private Movies movie_name;

    private boolean ticketStatus;

    @OneToOne
    private TicketsBooking booking;



}
