package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Movies;
import com.example.cinemaapp.Repository.MovieRepo;
import com.example.cinemaapp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class MovieServiceImpl  implements MovieService {
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movies acceptMovieDetails(Movies movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movies getMovieDetails(int id) throws Exception {
        return movieRepo.findById(id).orElseThrow(() -> new Exception("Movie not found for id: " + id));
    }

    @Override
    public Movies updateMovieDetails(int id, Movies movie) throws Exception {
        Movies savedMovie = getMovieDetails(id);
        return movieRepo.save(savedMovie);
    }

    public Movies getMovieById(Integer id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found."));
    }

    @Override
    public List<Movies> getAllMoviesDetails() {
        return movieRepo.findAll();
    }

}
