package com.example.cinemaapp.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "show")
@DynamicUpdate
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int showId;

    @OneToOne
    private Movie movie;

    @JsonIgnore
    @ManyToOne
    private Room room;

    @JsonIgnore
    @OneToOne
    private Booking booking;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate showDate;

    public Show(){}

    public Show(int showId, Movie movie, Room room, Booking booking, LocalDate showDate) {
        this.showId = showId;
        this.movie = movie;
        this.room = room;
        this.booking = booking;
        this.showDate = showDate;
    }
}
