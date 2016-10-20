package com.gc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.SeatType;

/**
 * Interface for SeatType DAO methods, using Spring Data
 */
@Repository
public interface SeatTypeRepo extends JpaRepository<SeatType, Integer> {
	
	/**
	 * Returns all SeatTypes
	 * @return A list of all SeatTypes
	 */
	List<SeatType> findAll();
}
