package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Ticket;

/**
 * Interface for Ticket DAO methods, using Spring Data
 */
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
	
	// No current methods
}
