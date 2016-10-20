package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Airplane;

/**
 * Interface for Airplane DAO methods, using Spring Data
 */
@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Integer> {
	
	/**
	 * Returns an Airplane by name
	 * @param name The name of the Airplane
	 * @return The Airplane with the name
	 */
	Airplane findByAirplaneName(String name);
}
