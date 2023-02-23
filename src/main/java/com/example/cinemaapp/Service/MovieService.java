package com.example.cinemaapp.Service;

import com.example.cinemaapp.Model.Movies;

import java.util.List;

public interface MovieService {


    Movies addMovie(Movies movie);

    Movies updateMovie(Movies movie);

    Movies removeMovie(Movies movie);

    Movies viewMovie(int movieId);

    List<Movies> viewMovieList();
}
