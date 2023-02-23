package com.example.cinemaapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Movies {

    @Id
    @GeneratedValue
    private Integer id;

    private String movie_name;

    private String movie_description;

    private String movie_image_link;
    private String room;

    public Movies(String movie_name,String movie_description,String movie_image_link)
    {
        this.movie_name=movie_name;
        this.movie_description=movie_description;
        this.movie_image_link=movie_image_link;
    }

}
