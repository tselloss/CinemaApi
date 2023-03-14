package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Seat;
import com.example.cinemaapp.Model.SeatStatus;
import com.example.cinemaapp.Repository.SeatRepo;
import com.example.cinemaapp.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepo seatRepo;
    @Override
    public Seat addSeat(Seat seat) throws Exception {
        if (seat != null) {
            if (seatRepo.existsById(seat.getSeatId())) {
                throw new Exception("Seat with this id already exists");
            } else {
                seatRepo.saveAndFlush(seat);
            }
        }
        return seatRepo.getOne(seat.getSeatId());
    }

    @Override
    public Seat bookSeat(Seat seat) throws Exception {
        seat.setStatus(SeatStatus.BOOKED);
        return seatRepo.saveAndFlush(seat);
    }

    @Override
    public List<Seat> viewSeatList() throws Exception {
        List<Seat> list = seatRepo.findAll();
        return list;
    }

}
