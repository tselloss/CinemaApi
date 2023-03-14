package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.DTO.MovieDTO;
import com.example.cinemaapp.Model.Movies;
import com.example.cinemaapp.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    ModelMapper modelmapper;



    @GetMapping(value="/movies",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMovies() {
        List<Movies> movieList = movieService.getAllMoviesDetails();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movies movies : movieList){
            movieDTOList.add(modelmapper.map(movies, MovieDTO.class));
        }
        return new ResponseEntity<>(movieDTOList, HttpStatus.OK);
    }

    @PostMapping(value="/movies/add",consumes= MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity newMovie(@RequestBody Movies movies) throws Exception {
        Movies addMovie = movieService.acceptMovieDetails(movies);
        return new ResponseEntity<Movies>(addMovie, HttpStatus.CREATED);
    }

    @PutMapping(value="/movies/{id}",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@PathVariable(name = "id") int id, @RequestParam MovieDTO movieDTO) throws Exception{
        Movies newMovie = modelmapper.map(movieDTO, Movies.class);
        Movies updatedMovie = movieService.updateMovieDetails(id, newMovie);
        MovieDTO updatedMovieDTO = modelmapper.map(updatedMovie, MovieDTO.class);
        return new ResponseEntity<>(updatedMovieDTO,HttpStatus.OK);
    }
}
