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

@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {
	public List<Seat> findByFlightOrderBySeatIdAsc(Flight flight);

	public Seat findByTicket(Ticket tick);
	
	@Modifying
	@Query("UPDATE Seat s SET s.ticket = null WHERE s.ticket.ticketId = :id")
	public int setTicketNullWhereTicketIdEquals(@Param("id") Integer id);

}
