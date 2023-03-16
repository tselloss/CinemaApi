package com.example.cinemaapp.Repository;

import com.example.cinemaapp.Model.Room;
import com.example.cinemaapp.Model.SeatLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatLockRepo extends JpaRepository<SeatLock, Integer> {
    @Query("select s.movieId from SeatLock s where s.movieId = ?1")
    public List<Integer> getLockedSeats(Integer movie_id) ;
    public List<SeatLock> findByMovieId(Integer movie_id) ;

}

