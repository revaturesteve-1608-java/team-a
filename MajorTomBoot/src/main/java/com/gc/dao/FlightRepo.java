package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Flight;

/**
 * Interface for Flight DAO methods, using Spring Data
 */
@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

	// No current methods
}
