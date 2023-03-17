package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Model.Show;
import com.example.cinemaapp.Repository.MoviesRepo;
import com.example.cinemaapp.Service.MovieService;
import com.example.cinemaapp.Service.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieServiceImpl  implements MovieService {
    @Autowired
    private MoviesRepo moviesRepo;
    @Autowired
    private ShowRepo showRepo;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return moviesRepo.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws Exception {
        return moviesRepo.findById(id).orElseThrow(() -> new Exception("Movie not found for id: " + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws Exception {
        Movie savedMovie = getMovieDetails(id);
        return moviesRepo.save(savedMovie);
    }

    public Movie getMovieById(Integer id) {
        return moviesRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found."));
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return moviesRepo.findAll();
    }

    @Override
    public Movie addMovieToShow(Movie movie, Integer showId) throws Exception {
        Show show=new Show();
        if (showId != null) {
            show = showRepo.getOne(showId);
            movie.setShow(show);
        }
        moviesRepo.saveAndFlush(movie);
        return moviesRepo.getOne(movie.getMovieId());
    }
}
