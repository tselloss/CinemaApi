package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Movies;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface MovieService {

    public Movies acceptMovieDetails(Movies movie);
    public Movies getMovieDetails(int id) throws Exception;
    public Movies updateMovieDetails(int id, Movies movie) throws Exception;
    public Movies getMovieById(Integer id) throws Exception;
    public List<Movies> getAllMoviesDetails();
}
