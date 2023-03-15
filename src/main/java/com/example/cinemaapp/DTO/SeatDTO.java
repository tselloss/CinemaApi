package com.example.cinemaapp.DTO;

import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.SeatStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class SeatDTO {

    private Integer seatId;
    private String seatNumber;
    private SeatStatus status;
    private double price;
    private LocalDate date;
    private Integer movieId;
    private String movieName;
    private List<String> seatNames;

    public SeatDTO(Seat seat) {
        this.seatId = seat.getSeatId();
        this.seatNumber = seat.getSeatNumber();
        this.status = seat.getStatus();
        this.price = seat.getPrice();
        this.date = LocalDate.parse(seat.getDate());
    }
}

