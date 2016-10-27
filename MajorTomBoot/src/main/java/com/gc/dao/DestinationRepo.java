package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gc.model.Destination;

/**
 * Interface for Destination DAO methods, using Spring Data
 */
@Repository
public interface DestinationRepo extends JpaRepository<Destination, Integer> {

	// No current methods
}
