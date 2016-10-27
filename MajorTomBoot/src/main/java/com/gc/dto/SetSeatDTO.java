package com.gc.dto;

import java.io.Serializable;

/**
 * Data transfer object containing info related to setting seats
 */
public class SetSeatDTO implements Serializable {

	private static final long serialVersionUID = 840054744840509755L;
	
	private int ticketId;
	private int seatId;
	
	/**
	 * No-args constructor
	 */
	public SetSeatDTO() {
		super();
	}

	/**
	 * Constructor with all fields
	 * @param ticketId Ticket id
	 * @param seatId Seat id
	 */
	public SetSeatDTO(int ticketId, int seatId) {
		super();
		this.ticketId = ticketId;
		this.seatId = seatId;
	}

	/**
	 * Gets the ticket id
	 * @return The ticket id
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * Sets the ticket id
	 * @param ticketId The ticket id
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Gets the seat id
	 * @return The seat id
	 */
	public int getSeatId() {
		return seatId;
	}

	/**
	 * Sets the seat id
	 * @param seatId The seat id
	 */
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "SelectSeatDTO [ticketId=" + ticketId + ", seatId=" + seatId + "]";
	}
	
}
