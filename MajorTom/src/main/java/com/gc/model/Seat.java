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
	@JoinColumn(name = "SEAT_TYPE_ID")
	Integer seatType;
	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	Integer flightId;
	
	
	public Seat() {
		super();
	}
	public Seat(Integer seatId, Integer seatType, Integer flightId) {
		super();
		this.seatId = seatId;
		this.seatType = seatType;
		this.flightId = flightId;
	}
	
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Integer getSeatType() {
		return seatType;
	}
	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType + ", flightId=" + flightId + "]";
	}
}
