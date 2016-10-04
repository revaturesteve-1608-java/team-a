package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT")
public class Seat {
	@Id
	@Column(name = "SEAT_ID")
	@SequenceGenerator(allocationSize = 1, name = "seatSeq", sequenceName = "SEAT_SEQ")
	@GeneratedValue(generator = "seatSeq", strategy = GenerationType.SEQUENCE)
	Integer seatId;
	
	@ManyToOne
	@JoinColumn(name = "SEAT_TYPE_ID")
	SeatType seatType;
	
	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	Flight flight;
	
	
	public Seat() {
		super();
	}
	public Seat(Integer seatId, SeatType seatType, Flight flight) {
		super();
		this.seatId = seatId;
		this.seatType = seatType;
		this.flight = flight;
	}
	
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public Flight getFlightId() {
		return flight;
	}
	public void setFlightId(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType + ", flight=" + flight + "]";
	}
}
