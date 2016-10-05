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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@Fetch(FetchMode.JOIN)
	Destination destination;
	
	@ManyToOne
	@JoinColumn(name = "AIRLINE_ID")
	@Fetch(FetchMode.JOIN)
	Airline airline;
	
	@ManyToOne
	@JoinColumn(name = "AIRPLANE_ID")
	@Fetch(FetchMode.JOIN)
	Airplane airplane;
	
	@OneToMany(mappedBy = "flight")
	@Fetch(FetchMode.JOIN)
	Set<Seat> seats;
	
	

	
	public Flight() {
	}
	public Flight(Destination destination, Airline airline) {
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
