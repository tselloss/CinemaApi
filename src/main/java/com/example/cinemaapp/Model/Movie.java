package com.example.cinemaapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    @Column(length = 1333, nullable = false, unique = true)
    private String movieName;
    @Column( length = 500, nullable = false)
    private String movie_description;
    @Column(length = 500, nullable = false)
    private String movie_image_link;

    public Movie(){}

    public Movie(String movieName, String movie_description, String movie_image_link, String trailerURL) {
        this.movieName = movieName;
        this.movie_description = movie_description;
        this.movie_image_link = movie_image_link;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return  movieName.equals(movie.movieName) &&
                movie_description.equals(movie.movie_description) &&
                movie_image_link.equals(movie.movie_image_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, movie_description, movie_image_link);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId + '\'' +
                ", name='" + movieName + '\'' +
                ", description='" + movie_description + '\'' +
                ", imageLink=" + movie_image_link +
                '}';
    }
}
