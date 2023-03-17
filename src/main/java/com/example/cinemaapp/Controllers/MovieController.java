package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.DTO.MovieDTO;
import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.SeatStatus;
import com.example.cinemaapp.Service.MovieService;
import com.example.cinemaapp.Service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a Spring REST Controller class for managing movie related operations.
 * It has three endpoints, one for getting all movies, one for adding a new movie and one for updating an existing movie.
 * It uses the MovieService to perform the business logic and the ModelMapper library for mapping between DTOs and entity objects
 * .The getAllMovies endpoint returns a list of MovieDTOs, the newMovie endpoint adds a new movie and returns the added movie,
 * and the updateMovieDetails endpoint updates an existing movie and returns the updated movie details in a MovieDTO format.
 */

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    ModelMapper modelmapper;

    @Autowired
    private SeatService seatService;


    @GetMapping(value="/getAllMovies",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMovies() {
        List<Movie> movieList = movieService.getAllMoviesDetails();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movie movie : movieList){
            movieDTOList.add(modelmapper.map(movie, MovieDTO.class));
        }
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
    }

    @PostMapping(value="/addMovie/add",consumes= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity addNewMovie(@RequestBody Movie movie, LocalDate date) throws Exception {
        List<Seat> seats = new ArrayList<>();
        for (int i=0; i<30; i++) {
            Seat seat= new Seat();
            seat.setStatus(SeatStatus.AVAILABLE);
            seat.setSeatNumber(String.valueOf(i+1));
            seat.setPrice(10.0);
            seat.setDate(date);
            seat.setRoomID(1);
            Seat addseat = seatService.addSeat(seat);
            seats.add(addseat);
        }
        Movie addMovie = movieService.acceptMovieDetails(movie);
        Map<String, Object> response = new HashMap<>();
        response.put("seats", seats);
        response.put("movie", addMovie);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/map", consumes = "application/json")
    public ResponseEntity<Movie> addToShow(@RequestBody Movie movie,@RequestParam Integer showId)
            throws Exception {
        movie = movieService.addMovieToShow(movie,showId);
        return ResponseEntity.ok(movie);
    }

    @PutMapping(value="/updateMovie/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@PathVariable(name = "id") int id, @RequestParam MovieDTO movieDTO) throws Exception{
        Movie newMovie = modelmapper.map(movieDTO, Movie.class);
        Movie updatedMovie = movieService.updateMovieDetails(id, newMovie);
        MovieDTO updatedMovieDTO = modelmapper.map(updatedMovie, MovieDTO.class);
        return ResponseEntity.ok(updatedMovieDTO);
    }
}
