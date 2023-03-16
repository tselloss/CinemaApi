package com.example.cinemaapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatLock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seatLockId;

    private Integer movieId;

    @OneToOne
    private Seat seat;


}
