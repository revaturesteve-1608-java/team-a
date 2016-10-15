package com.gc.dto;

public class ReassignSeatDTO {

	private int ticketId;
	private int seatId;
	private int seat2Id;
	private int loginToken;
	
	public ReassignSeatDTO() {
		super();
	}

	public ReassignSeatDTO(int ticketId, int seatId, int seat2Id, int loginToken) {
		super();
		this.ticketId = ticketId;
		this.seatId = seatId;
		this.seat2Id = seat2Id;
		this.loginToken = loginToken;
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

	public int getSeat2Id() {
		return seat2Id;
	}

	public void setSeat2Id(int seat2Id) {
		this.seat2Id = seat2Id;
	}

	public int getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(int loginToken) {
		this.loginToken = loginToken;
	}

	@Override
	public String toString() {
		return "ReassignSeatDTO [ticketId=" + ticketId + ", seatId=" + seatId + ", seat2Id=" + seat2Id + ", loginToken="
				+ loginToken + "]";
	}

	
	
}
