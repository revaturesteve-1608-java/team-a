package com.gc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Flight;
import com.gc.model.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
	public List<Seat> findByFlight(Flight flight);
}
