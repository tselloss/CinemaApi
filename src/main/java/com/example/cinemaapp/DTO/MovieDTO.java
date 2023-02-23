package com.example.cinemaapp.DTO;

public class MovieDTO {
        int movie_id;
        String movieName;
        String movie_description;

        String movie_image_link;


        public int getMovie_id() {
            return movie_id;
        }

        public void setMovie_id(int movie_id) {
            this.movie_id = movie_id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getMovie_description() {
            return movie_description;
        }

        public void setMovie_description(String movie_description) {
            this.movie_description = movie_description;
        }


        public String getMovie_image_link() {
            return movie_image_link;
        }

        public void setMovie_image_link(String movie_image_link) {
            this.movie_image_link = movie_image_link;
        }

}
