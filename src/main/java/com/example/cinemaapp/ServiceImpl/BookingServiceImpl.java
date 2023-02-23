package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.TicketsBooking;
import com.example.cinemaapp.Repository.BookingRepo;
import com.example.cinemaapp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public TicketsBooking addBooking(TicketsBooking booking) {

        return bookingRepo.save(booking);
    }

    @Override
    public TicketsBooking updateBooking(TicketsBooking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public TicketsBooking cancelBooking(TicketsBooking booking) {
        bookingRepo.delete(booking);
        return booking;
    }

    @Override
    public List<TicketsBooking> showAllBooking() {

        return bookingRepo.findAll();
    }

}
