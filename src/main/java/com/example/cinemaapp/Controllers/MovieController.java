package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.DTO.MovieDTO;
import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping(value="/movies",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMovies() {
        List<Movie> movieList = movieService.getAllMoviesDetails();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movie movie : movieList){
            movieDTOList.add(modelmapper.map(movie, MovieDTO.class));
        }
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
    }

    @PostMapping(value="/movies/add",consumes= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity newMovie(@RequestBody Movie movie) throws Exception {
        Movie addMovie = movieService.acceptMovieDetails(movie);
        return ResponseEntity.ok(addMovie);
    }
    @PutMapping(value="/movies/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@PathVariable(name = "id") int id, @RequestParam MovieDTO movieDTO) throws Exception{
        Movie newMovie = modelmapper.map(movieDTO, Movie.class);
        Movie updatedMovie = movieService.updateMovieDetails(id, newMovie);
        MovieDTO updatedMovieDTO = modelmapper.map(updatedMovie, MovieDTO.class);
        return ResponseEntity.ok(updatedMovieDTO);
    }
}
