package com.example.cinemaapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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

}
