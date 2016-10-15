package com.gc.dto;

public class SetSeatDTO {

	private int ticketId;
	private int seatId;
	
	public SetSeatDTO() {
		super();
	}

	public SetSeatDTO(int ticketId, int seatId) {
		super();
		this.ticketId = ticketId;
		this.seatId = seatId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	@Override
	public String toString() {
		return "SelectSeatDTO [ticketId=" + ticketId + ", seatId=" + seatId + "]";
	}
	
}
