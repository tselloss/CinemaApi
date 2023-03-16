package com.example.cinemaapp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    private Double price;
    private String date;

    @ManyToOne
    @JsonBackReference
    private Room room;
}
