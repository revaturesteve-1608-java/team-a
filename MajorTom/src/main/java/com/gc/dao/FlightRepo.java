package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

}
