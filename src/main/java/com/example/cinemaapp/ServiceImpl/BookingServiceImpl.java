package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Booking;
import com.example.cinemaapp.Repository.BookingRepo;
import com.example.cinemaapp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Booking cancelBooking(Booking booking) {
        bookingRepo.delete(booking);
        return booking;
    }

    @Override
    public List<Booking> showAllBooking() {
        return bookingRepo.findAll();
    }

    @Override
    public List<Booking> showAllBookings(LocalDate bookingdate) throws Exception {
        List<Booking> bkList = new ArrayList<>();
        for (Booking booking : bookingRepo.findAll()) {
            if (booking.getBookingDate() != null && booking.getBookingDate().isEqual(bookingdate)) {
                bkList.add(booking);
            }
        }
        if (bkList.size() == 0)
            throw new Exception("No bookings found");
        else {
            return bkList;
        }
    }

    @Override
    public Booking viewBooking(int bookingid) throws Exception {
        return bookingRepo.findById(bookingid).get();
    }
}
