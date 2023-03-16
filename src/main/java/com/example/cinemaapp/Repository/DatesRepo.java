package com.example.cinemaapp.Repository;

import com.example.cinemaapp.Model.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DatesRepo extends JpaRepository<Date, Integer> {
    Date findByDateId(Integer id);
}
