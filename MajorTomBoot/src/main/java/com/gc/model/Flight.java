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

/**
 * Represents the Flight table in the database, mapped with Hibernate
 */
@Entity
@Table(name = "FLIGHT")
public class Flight {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name = "FLIGHT_ID")
	@SequenceGenerator(allocationSize = 1, name = "flightSeq", sequenceName = "FLIGHT_SEQ")
	@GeneratedValue(generator = "flightSeq", strategy = GenerationType.SEQUENCE)
	Integer flightId;
	
	/**
	 * The destination, which is identified by DESTINATION_ID in the DB
	 */
	@ManyToOne
	@JoinColumn(name = "DESTINATION_ID")
	@Fetch(FetchMode.JOIN)
	Destination destination;
	
	/**
	 * The airline, which is identified by AIRLINE_ID in the DB
	 */
	@ManyToOne
	@JoinColumn(name = "AIRLINE_ID")
	@Fetch(FetchMode.JOIN)
	Airline airline;
	
	/**
	 * The airplane, which is identified by AIRPLANE_ID in the DB
	 */
	@ManyToOne
	@JoinColumn(name = "AIRPLANE_ID")
	@Fetch(FetchMode.JOIN)
	Airplane airplane;

	/**
	 * No-args constructor
	 */
	public Flight() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param destination The destination
	 * @param airline The airline
	 * @param airplane The airplane
	 */
	public Flight(Destination destination, Airline airline, Airplane airplane) {
		super();
		this.destination = destination;
		this.airline = airline;
		this.airplane = airplane;
	}

	/**
	 * Gets the flight id
	 * @return The flight id
	 */
	public Integer getFlightId() {
		return flightId;
	}
	
	/**
	 * Sets flight id
	 * @param flightId The flight id
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	
	/**
	 * Gets the destination
	 * @return The destination
	 */
	public Destination getDestination() {
		return destination;
	}
	
	/**
	 * Sets the destination
	 * @param destination The destination
	 */
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	/**
	 * Gets the airline
	 * @return The airline
	 */
	public Airline getAirline() {
		return airline;
	}
	
	/**
	 * Sets the airline
	 * @param airline The airline
	 */
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	/**
	 * Gets the airplane
	 * @return The airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}
	
	/**
	 * Sets the airplane
	 * @param airline The airplane
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", destination=" + destination + ", airline=" + airline + ", airplane=" + airplane + "]";
	}
}
