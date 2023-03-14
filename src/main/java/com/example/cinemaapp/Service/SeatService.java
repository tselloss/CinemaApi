package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Seat;

import java.util.List;

public interface SeatService {
    public Seat addSeat(Seat seat) throws Exception;
    public Seat bookSeat(Seat seat) throws Exception;
    public List<Seat> viewSeatList() throws Exception;

}
