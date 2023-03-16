package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.SeatLock;
import com.example.cinemaapp.Repository.BookingRepo;
import com.example.cinemaapp.Repository.MoviesRepo;
import com.example.cinemaapp.Repository.SeatLockRepo;
import com.example.cinemaapp.Repository.SeatRepo;
import com.example.cinemaapp.Service.SeatLockedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatLockedServiceImpl implements SeatLockedService {

    @Autowired
    private SeatLockRepo seatLockRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private MoviesRepo moviesRepo;


    @Override
    public List<Seat> getAllLockedSeats(SeatLock seatLock) throws Exception {
        List<Integer> lockedSeatIds = seatLockRepo.getLockedSeats(seatLock.getSeatLockId());
        List<Seat> lockedSeats = new ArrayList<>();
        for(Integer seatId : lockedSeatIds) {
            lockedSeats.add(seatRepo.findById(seatId).get() );
        }
        return lockedSeats;
    }

}
