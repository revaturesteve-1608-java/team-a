package com.gc.dto;

/**
 * Data transfer object containing info related to reassigning seats
 */
public class ReassignSeatDTO {

	private int ticketId;
	private int seatId;
	private int seat2Id;
	private int loginToken;
	
	/**
	 * No-args constructor
	 */
	public ReassignSeatDTO() {
		super();
	}

	/**
	 * Constructor with all fields
	 * @param ticketId The ticket id
	 * @param seatId The seat id of the first seat
	 * @param seat2Id The seat id of the second seat
	 * @param loginToken The login token
	 */
	public ReassignSeatDTO(int ticketId, int seatId, int seat2Id, int loginToken) {
		super();
		this.ticketId = ticketId;
		this.seatId = seatId;
		this.seat2Id = seat2Id;
		this.loginToken = loginToken;
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
	 * Gets the 1st seat id
	 * @return The 1st seat id
	 */
	public int getSeatId() {
		return seatId;
	}

	/**
	 * Sets the 1st seat id
	 * @param seatId The 1st seat id
	 */
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	/**
	 * Gets the 2nd seat id
	 * @return The 2nd seat id
	 */
	public int getSeat2Id() {
		return seat2Id;
	}

	/**
	 * Sets the 2nd seat id
	 * @param seat2Id The 2nd seat id
	 */
	public void setSeat2Id(int seat2Id) {
		this.seat2Id = seat2Id;
	}

	/**
	 * Gets the login token
	 * @return The login token
	 */
	public int getLoginToken() {
		return loginToken;
	}

	/**
	 * Sets the login token
	 * @param loginToken The login token
	 */
	public void setLoginToken(int loginToken) {
		this.loginToken = loginToken;
	}

	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "ReassignSeatDTO [ticketId=" + ticketId + ", seatId=" + seatId + ", seat2Id=" + seat2Id + ", loginToken="
				+ loginToken + "]";
	}

	
	
}
