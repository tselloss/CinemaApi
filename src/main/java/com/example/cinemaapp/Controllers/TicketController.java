package com.example.cinemaapp.Controllers;


import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.Tickets;
import com.example.cinemaapp.Repository.SeatRepo;
import com.example.cinemaapp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService service;
    @Autowired
    private SeatRepo seatRepo;

    @GetMapping("/tickets")
    public List<Tickets> getAllTickets(){
        return service.viewAllTickets();
    }

    @PostMapping("/ticket")
    public Tickets addTicket(@RequestBody Tickets ticket){
        return service.addTicket(ticket);
    }

    @PutMapping("/ticket")
    public Tickets updateTicket(@RequestBody Tickets ticket){
        return service.updateTicket(ticket);
    }

    @DeleteMapping("/ticket")
    public Tickets deleteTicket(@RequestBody Tickets ticket){
        return service.removeTicket(ticket);
    }

    @PostMapping("/ticket/{id}/addSeat")
    public Tickets addSeat(@PathVariable("id") Integer id, @RequestBody Seat seat){
        Tickets t = service.viewTicket(id);
        addSeat(id, seat);
        seatRepo.save(seat);
        return t;
    }

    @DeleteMapping("/ticket/{id}/removeSeat")
    public Tickets removeSeat(@PathVariable("id") Integer id, @RequestBody Seat seat){
        Tickets t = service.viewTicket(id);
        deleteTicket(t);
        seatRepo.delete(seat);
        return t;
    }
}
