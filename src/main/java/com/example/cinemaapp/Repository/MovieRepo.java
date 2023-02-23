package com.example.cinemaapp.Repository;

import com.example.cinemaapp.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepo extends JpaRepository<Movies, Integer>{
    public List<Movies> findByMovieName(String movieName);
}