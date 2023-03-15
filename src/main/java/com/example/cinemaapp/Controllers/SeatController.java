package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.DTO.MovieDTO;
import com.example.cinemaapp.DTO.SeatDTO;
import com.example.cinemaapp.Model.Movies;
import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Repository.MovieRepo;
import com.example.cinemaapp.Repository.SeatRepo;
import com.example.cinemaapp.Service.MovieService;
import com.example.cinemaapp.Service.SeatService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SeatController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    SeatService seatService;

    @Autowired
    SeatRepo seatRepo;

    @PostMapping("/seat/add")
    public ResponseEntity<Seat> addASeat(@RequestBody Seat seat) throws Exception{
        seat = seatService.addSeat(seat);
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }

    @GetMapping("/seat/{movieId}/{movieName}")
    public List<Seat> getSeatsByMovieIdAndName(@PathVariable Integer movieId, @RequestParam String movieName) throws Exception {
        Movies movie = movieService.getMovieById(movieId);
        if (!movie.getMovieName().equals(movieName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie name does not match.");
        }
        return seatService.getSeatsByMovieId(movieId);
    }


}
