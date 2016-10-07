package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Seat;
import com.gc.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}
