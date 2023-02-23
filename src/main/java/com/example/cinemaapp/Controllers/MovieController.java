package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Model.Movies;
import com.example.cinemaapp.Repository.MovieRepo;
import com.example.cinemaapp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/movies")
    public List<Movies> getAllMovies() {
        return movieService.viewMovieList();
    }

    @PostMapping("/movie")
    public Movies addMovie(@RequestBody Movies movies) {
        return movieService.addMovie(movies);
    }

    @PutMapping("/movie")
    public Movies updateMovie(@RequestBody Movies movies) {
        return movieService.updateMovie(movies);
    }

    @DeleteMapping("/movie")
    public Movies deleteMovie(@RequestBody Movies movies) {
        return movieService.removeMovie(movies);
    }
}
