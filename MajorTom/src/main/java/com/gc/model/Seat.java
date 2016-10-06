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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@Fetch(FetchMode.JOIN)
	SeatType seatType;
	
	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	@Fetch(FetchMode.JOIN)
	Flight flight;
	
	
	public Seat() {
	}
	public Seat(SeatType seatType, Flight flight) {
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
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType + ", flight=" + flight + "]";
	}
}
