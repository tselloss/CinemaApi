package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Seat;

public interface SeatService {

    Seat bookSeat(Seat seat);

    Seat cancelSeatBooking(Seat seat);

    Seat blockSeat(Seat seat);
}
