package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.TicketsBooking;

import java.util.List;

public interface BookingService {

    TicketsBooking addBooking(TicketsBooking booking);

    TicketsBooking updateBooking(TicketsBooking booking);

    TicketsBooking cancelBooking(TicketsBooking booking);

    List<TicketsBooking> showAllBooking();
}
