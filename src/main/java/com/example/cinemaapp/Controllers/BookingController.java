package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Model.TicketsBooking;
import com.example.cinemaapp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *This is a Spring Boot controller class that provides REST endpoints for managing bookings.
 *It uses dependency injection to inject a BookingService instance and defines four methods:
 *getAllBookings: retrieves all existing bookings via a GET request to "/bookings".
 *addBooking: creates a new booking via a POST request to "/booking" and returns the created booking.
 *updateBooking: updates an existing booking via a PUT request to "/booking" and returns the updated booking.
 *deleteBooking: cancels an existing booking via a DELETE request to "/booking" and returns the cancelled booking.
 * All endpoints expect and return JSON data in the TicketsBooking format.
 */

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<TicketsBooking> getAllBookings(){
        return bookingService.showAllBooking();
    }

    @PostMapping("/booking")
    public TicketsBooking addBooking(@RequestBody TicketsBooking booking){
        return bookingService.addBooking(booking);
    }

    @PutMapping("/booking")
    public TicketsBooking updateBooking(@RequestBody TicketsBooking booking){
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/booking")
    public TicketsBooking deleteBooking(@RequestBody TicketsBooking booking){
        return bookingService.cancelBooking(booking);
    }
}
