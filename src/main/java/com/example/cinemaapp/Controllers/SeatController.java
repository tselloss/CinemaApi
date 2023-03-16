package com.example.cinemaapp.Controllers;

import com.example.cinemaapp.Model.*;
import com.example.cinemaapp.Repository.*;
import com.example.cinemaapp.Service.MovieService;
import com.example.cinemaapp.Service.SeatLockedService;
import com.example.cinemaapp.Service.SeatService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private MovieService movieService;
    @Autowired
    SeatService seatService;
    @Autowired
    SeatLockedService seatLockedService;

    @Autowired
    SeatLockRepo seatLockRepo;
    @Autowired
    DatesRepo datesRepo;

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    MoviesRepo moviesRepo;

    @PostMapping("/seat/add")
    public ResponseEntity<Seat> addASeat(@RequestBody Seat seat) throws Exception{
        seat = seatService.addSeat(seat);
        return ResponseEntity.ok(seat);
    }

    @GetMapping("/seat/{movieId}")
    public Date getDatesByMovieId(@PathParam("id") Integer id) throws Exception {
        Seat seat= seatRepo.findBySeatId(id);
        Date date = datesRepo.findByDateId(id);
        Movie movie= moviesRepo.findMoviesByMovieId(id);
        Room room= roomRepo.findByRoomId(id);
        List<Room> roomsList= new ArrayList<>();
        List<Seat> seatsList= new ArrayList<>();
        seatsList.add(seat);
        room.setMovie(movie);
        room.setSeats(seatsList);
        roomsList.add(room);
        date.setRoom(roomsList);
//        Room room1= new Room();
//        room1.setSeats(seat);
//        room1.setMovie(movie);
//        room.add(room1);
//        List<Room> dateRoom= new ArrayList<>();
//        dateRoom.add(room1);
//        date.setRoom(dateRoom);
        return date;
    }


    @GetMapping("/seat/lockedSeats")
    public ResponseEntity<List<Seat>> getLockedSeatsHandler(@RequestParam List<SeatLock> seatLockList ) throws Exception {
        List<Seat> seats= seatRepo.findAll();
        System.out.println("Find all seats");
        for(Seat seat: seats) {
            for (SeatLock seatLock : seatLockList) {
               // List<Seat> getLockedSeats = seatLockedService.getAllLockedSeats(seatLock);
                seatLock.setSeatLockId(seat.getSeatId());
                seatLock.getSeat().setStatus(SeatStatus.BOOKED);
                System.out.println("change status");
                seatLock.setSeat(seat);
                seatLockRepo.save(seatLock);
                System.out.println("save repo");
            }
        }
        System.out.println("After loop");
        return ResponseEntity.ok(new ArrayList<>());
    }
}
