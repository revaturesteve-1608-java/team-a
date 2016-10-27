package com.gc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gc.model.Flight;
import com.gc.model.Seat;
import com.gc.model.Ticket;

/**
 * Interface for Seat DAO methods, using Spring Data
 */
@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
	
	/**
	 * Returns all Seats by Flight, ordered by seatId in ascending order
	 * @param flight The Flight object
	 * @return List of all Seats by flight, ordered by seatId in ascending order
	 */
	public List<Seat> findByFlightOrderBySeatIdAsc(Flight flight);

	/**
	 * Returns a Seat by Ticket
	 * @param tick The Ticket
	 * @return The Seat with that Ticket
	 */
	public Seat findByTicket(Ticket tick);
	
	/**
	 * Removes all Tickets from Seats having a particular ticketId
	 * @param id The ticketId
	 * @return Number of rows affected
	 */
	@Modifying
	@Query("UPDATE Seat s SET s.ticket = null WHERE s.ticket.ticketId = :id")
	public int setTicketNullWhereTicketIdEquals(@Param("id") Integer id);

}
