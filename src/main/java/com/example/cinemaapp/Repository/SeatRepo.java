package com.example.cinemaapp.Repository;

import com.example.cinemaapp.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
