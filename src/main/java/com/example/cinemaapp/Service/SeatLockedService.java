package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.SeatLock;
import com.example.cinemaapp.Model.TicketsBooking;

import java.util.List;

public interface SeatLockedService {

    public List<Seat> getAllLockedSeats(SeatLock seatLock) throws Exception;

}
