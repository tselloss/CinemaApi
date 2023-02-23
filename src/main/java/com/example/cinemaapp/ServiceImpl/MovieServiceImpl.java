package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Movies;
import com.example.cinemaapp.Repository.MovieRepo;
import com.example.cinemaapp.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl  implements MovieService {
        @Autowired
        private MovieRepo repo;

        @Override
        public Movies addMovie(Movies movies) {

            return repo.save(movies);
        }

        @Override
        public Movies updateMovie(Movies movies) {
            return repo.save(movies);
        }

        @Override
        public Movies removeMovie(Movies movies) {
            repo.delete(movies);
            return movies;
        }

        @Override
        public Movies viewMovie(int movieId) {
             return repo.findById(movieId).orElse(new Movies());
        }

        @Override
        public List<Movies> viewMovieList() {
            return repo.findAll();
        }
}
