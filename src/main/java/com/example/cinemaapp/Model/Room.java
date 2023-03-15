package com.example.cinemaapp.Model;

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
    private int room_id;
    private String room_name;
    private int num_of_seats;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> seats;
}
