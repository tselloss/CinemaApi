package com.example.cinemaapp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Room {
    @Id
    @GeneratedValue
    private int roomId;
    private String room_name;
    private int num_of_seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seat> seats;

    @OneToOne
    private Movie movie;


}
