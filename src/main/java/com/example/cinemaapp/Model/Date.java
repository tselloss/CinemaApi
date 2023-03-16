package com.example.cinemaapp.Model;

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
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dateId;

    @OneToMany
    @JsonManagedReference
    private List<Room> room;
}
