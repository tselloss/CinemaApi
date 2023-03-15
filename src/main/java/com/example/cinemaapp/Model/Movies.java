package com.example.cinemaapp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movie_id;
    @Column(length = 1333, nullable = false, unique = true)
    private String movieName;
    @Column( length = 500, nullable = false)
    private String movie_description;
    @Column(length = 500, nullable = false)
    private String movie_image_link;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private List<Room> room;


    public Movies(){}

    public Movies(String movieName, String movie_description,String movie_image_link, String trailerURL) {
        this.movieName = movieName;
        this.movie_description = movie_description;
        this.movie_image_link = movie_image_link;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movie = (Movies) o;
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
                "id=" + movie_id + '\'' +
                ", name='" + movieName + '\'' +
                ", description='" + movie_description + '\'' +
                ", imageLink=" + movie_image_link +
                '}';
    }
}
