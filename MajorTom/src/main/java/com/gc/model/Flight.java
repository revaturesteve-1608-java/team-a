package com.gc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight {
	@Id
	@Column(name = "FLIGHT_ID")
	@SequenceGenerator(allocationSize = 1, name = "flightSeq", sequenceName = "FLIGHT_SEQ")
	@GeneratedValue(generator = "flightSeq", strategy = GenerationType.SEQUENCE)
	Integer flightId;
	
	@ManyToOne
	@JoinColumn(name = "DESTINATION_ID")
	Destination destination;
	
	@ManyToOne
	@JoinColumn(name = "AIRLINE_ID")
	Airline airline;
	
	@OneToMany(mappedBy = "flight")
	Set<Seat> seats;

	
	public Flight() {
		super();
	}
	public Flight(Integer flightId, Destination destination, Airline airline) {
		super();
		this.flightId = flightId;
		this.destination = destination;
		this.airline = airline;
	}

	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Set<Seat> getSeats() {
		return seats;
	}
	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
	
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", destination=" + destination + ", airline=" + airline + ", seats="
				+ seats + "]";
	}
}
