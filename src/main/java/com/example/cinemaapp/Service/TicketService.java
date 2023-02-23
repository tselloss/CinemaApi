package com.example.cinemaapp.Service;
import com.example.cinemaapp.Model.Tickets;
import java.util.List;

public interface TicketService {
    Tickets addTicket(Tickets ticket);
    Tickets updateTicket(Tickets ticket);
    Tickets removeTicket(Tickets ticket);
    List<Tickets> viewAllTickets();
    Tickets viewTicket(Integer id);

}
