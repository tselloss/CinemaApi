package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Tickets;
import com.example.cinemaapp.Repository.TicketsRepo;
import com.example.cinemaapp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketsRepo ticketsRepo;

    @Override
    public Tickets addTicket(Tickets ticket) {

        return ticketsRepo.save(ticket);
    }

    @Override
    public Tickets updateTicket(Tickets ticket) {
        return ticketsRepo.save(ticket);
    }

    @Override
    public Tickets removeTicket(Tickets ticket) {
        ticketsRepo.delete(ticket);
        return ticket;
    }

    @Override
    public List<Tickets> viewAllTickets() {

        return ticketsRepo.findAll();
    }

    @Override
    public Tickets viewTicket(Integer id) {
        return ticketsRepo.findById(id).get();
    }

    @Override
    public Tickets viewTicketMovieRoomSeats(Tickets tickets) {
       // ticketsRepo.
        return null;
    }
}