package com.example.cinemaapp.Repository;

import com.example.cinemaapp.Model.TicketsBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<TicketsBooking, Integer> {}
