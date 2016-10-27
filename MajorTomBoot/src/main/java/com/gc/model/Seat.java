package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Represents the Seat table in the database, mapped with Hibernate
 */
@Entity
@Table(name = "SEAT")
public class Seat {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name = "SEAT_ID")
	@SequenceGenerator(allocationSize = 1, name = "seatSeq", sequenceName = "SEAT_SEQ")
	@GeneratedValue(generator = "seatSeq", strategy = GenerationType.SEQUENCE)
	Integer seatId;
	
	/**
	 * The seat type, which is identified by SEAT_TYPE_ID in the DB
	 */
	@ManyToOne
	@JoinColumn(name = "SEAT_TYPE_ID")
	@Fetch(FetchMode.JOIN)
	SeatType seatType;
	
	/**
	 * The flight, which is identified by FLIGHT_ID in the DB
	 */
	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	@Fetch(FetchMode.JOIN)
	Flight flight;
	
	/**
	 * The ticket, which is identified by TICKET_ID in the DB
	 */
	@OneToOne
	@JoinColumn(name="TICKET_ID")
	@Fetch(FetchMode.JOIN)
	Ticket ticket;
	
	/**
	 * No-args constructor
	 */
	public Seat() {
		super();
	}
	
	/**
	 * Constructor for all non-PK fields
	 * @param seatType The seat type
	 * @param flight The flight
	 */
	public Seat(SeatType seatType, Flight flight) {
		super();
		this.seatType = seatType;
		this.flight = flight;
	}
	
	/**
	 * Gets the seat id
	 * @return The seat id
	 */
	public Integer getSeatId() {
		return seatId;
	}
	
	/**
	 * Sets the seat id
	 * @param seatId The seat id
	 */
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	
	/**
	 * Gets the seat type
	 * @return The seat type
	 */
	public SeatType getSeatType() {
		return seatType;
	}
	
	/**
	 * Sets the seat type
	 * @param seatType The seat type
	 */
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	/**
	 * Gets the flight
	 * @return The flight
	 */
	public Flight getFlight() {
		return flight;
	}
	
	/**
	 * Sets the flight
	 * @param flight The flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	/**
	 * Gets the ticket
	 * @return The ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}
	
	/**
	 * Sets the ticket
	 * @param ticket The ticket
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType + ", flight=" + flight + "]";
	}
}
