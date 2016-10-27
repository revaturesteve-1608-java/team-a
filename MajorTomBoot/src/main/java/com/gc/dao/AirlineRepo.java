package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Airline;

/**
 * Interface for Airline DAO methods, using Spring Data
 */
@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
	
	/**
	 * Returns an Airline by name
	 * @param name The name of the Airline
	 * @return The Airline with the name
	 */
	public Airline findByName(String name);
}
