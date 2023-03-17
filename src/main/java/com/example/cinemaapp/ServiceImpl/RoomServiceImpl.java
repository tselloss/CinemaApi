package com.example.cinemaapp.ServiceImpl;

import com.example.cinemaapp.Model.Movie;
import com.example.cinemaapp.Model.Room;
import com.example.cinemaapp.Model.Show;
import com.example.cinemaapp.Repository.MoviesRepo;
import com.example.cinemaapp.Repository.RoomRepo;
import com.example.cinemaapp.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private MoviesRepo moviesRepo;
    @Override
    public List<Room> getAllRoom() throws Exception {
        List<Room> rooms= roomRepo.findAll();
        return  rooms;
    }

    @Override
    public Room findRoom(int roomId) {
        // TODO Auto-generated method stub
        if (roomRepo.findById(roomId).isPresent()) {
            return roomRepo.findById(roomId).get();
        } else
            return null;
    }

    @Override
    public Room addRoom(Room room) throws Exception {
        if (room != null) {
            if (roomRepo.existsById(room.getRoomId())) {
                throw new Exception("Room already exists");
            } else {
                roomRepo.saveAndFlush(room);
            }
        }
        return room;
    }

    @Override
    public List<Room> updateRoom(Room room) {
        // TODO Auto-generated method stub
        roomRepo.saveAndFlush(room);
        return roomRepo.findAll();
    }

    @Override
    public List<Room> deleteRoomById(int roomId) {
        // TODO Auto-generated method stub
        roomRepo.deleteById(roomId);
        return roomRepo.findAll();
    }

    @Override
    public List<Room> findRoomByMovie(Integer movieId) throws Exception {
        List<Room> roomList=new ArrayList<>();
        Movie movie=moviesRepo.findById(movieId).get();
        Integer showID=movie.getShow().getShowId();
        List<Room> rooms = roomRepo.findAll();
        for(Room room:rooms) {
            List<Show> shows =room.getShow();
            for(Show show:shows){
                if(show.getShowId()==showID) {
                    roomList.add(room);
                }
            }
        }
        return roomList;
    }
}
