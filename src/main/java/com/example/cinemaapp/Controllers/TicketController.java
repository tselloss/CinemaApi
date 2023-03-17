package com.example.cinemaapp.Controllers;


import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.Tickets;
import com.example.cinemaapp.Repository.SeatRepo;
import com.example.cinemaapp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This code defines a REST API for managing movie tickets.
 * It includes endpoints for retrieving all tickets, adding a new ticket,
 * updating an existing ticket, and deleting a ticket.
 * Additionally, it provides endpoints for adding or removing a seat from a specific ticket.
 * The code uses the TicketService to perform CRUD operations on tickets,
 * and the SeatRepo to persist seat data to a database.
 * The HTTP methods used in this API include GET, POST, PUT, and DELETE.
 */

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private SeatRepo seatRepo;

    @GetMapping("/getAllTickets")
    public ResponseEntity<List<Tickets>> getAllTickets(){
        return ResponseEntity.ok(ticketService.viewAllTickets());
    }

    @PostMapping("/addTicker")
    public ResponseEntity<Tickets> addATicket(@RequestBody Tickets ticket,@RequestParam(required = false) Integer bookingId)
            throws Exception {

        ticket = ticketService.addTicket(ticket,bookingId);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/updateTicket")
    public Tickets updateTicket(@RequestBody Tickets ticket){
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/deleteTicket")
    public Tickets deleteTicket(@RequestBody Tickets ticket){
        return ticketService.removeTicket(ticket);
    }

    @PostMapping("/ticket/{id}/addSeat")
    public Tickets addSeat(@PathVariable("id") Integer id, @RequestBody Seat seat){
        Tickets tickets= ticketService.viewTicket(id);
        addSeat(id, seat);
        seatRepo.save(seat);
        return tickets;
    }

    @DeleteMapping("/ticket/{id}/removeSeat")
    public Tickets removeSeat(@PathVariable("id") Integer id, @RequestBody Seat seat){
        Tickets tickets = ticketService.viewTicket(id);
        deleteTicket(tickets);
        seatRepo.delete(seat);
        return tickets;
    }
}
