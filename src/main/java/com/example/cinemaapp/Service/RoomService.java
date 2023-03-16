package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Room;

public interface RoomService {


    public Room addSeatsToRoom(Integer rows,Integer cols,Integer screenId,Double seatPrice) throws Exception ;
}
