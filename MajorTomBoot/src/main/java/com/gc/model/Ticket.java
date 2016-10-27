package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Represents the Ticket table in the database, mapped with Hibernate
 */
@Entity
@Table(name="TICKET")
public class Ticket {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name="TICKET_ID")
	@SequenceGenerator(allocationSize=1,name="ticketSeq",sequenceName="TICKET_SEQ")
	@GeneratedValue(generator="ticketSeq",strategy=GenerationType.SEQUENCE)
	Integer ticketId;
	
	/**
	 * The first name
	 */
	@Column(name="FIRST_NAME")
	String firstName;
	
	/**
	 * The last name
	 */
	@Column(name="LAST_NAME")
	String lastName;
	
	/**
	 * The email
	 */
	@Column(name="EMAIL", length=1023)
	String email;
	
	/**
	 * The phone number
	 */
	@Column(name="PHONE", length=31)
	String phone;
	
	/**
	 * The flight, which is identified by FLIGHT_ID in the DB
	 */
	@OneToOne
	@JoinColumn(name="FLIGHT_ID")
	@Fetch(FetchMode.JOIN)
	Flight flight;
	
	/**
	 * The seat type, which is identified by SEAT_TYPE_ID in the DB
	 */
	@OneToOne
	@JoinColumn(name="SEAT_TYPE_ID")
	@Fetch(FetchMode.JOIN)
	SeatType seatType;
	
	/**
	 * No-args constructor
	 */
	public Ticket() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param firstName The first name
	 * @param lastName The last name
	 * @param email The email
	 * @param phone The phone
	 * @param flight The flight
	 * @param seatType The seat type
	 */
	public Ticket(String firstName, String lastName, String email, String phone, Flight flight, SeatType seatType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.flight = flight;
		this.seatType = seatType;
	}
	
	/**
	 * Gets the ticket id
	 * @return The ticket id
	 */
	public Integer getTicketId() {
		return ticketId;
	}
	
	/**
	 * Sets the ticket id
	 * @param ticketId The ticket id
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	/**
	 * Gets the first name
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name
	 * @param firstName The first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name
	 * @param lastName The last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the email
	 * @return The email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email
	 * @param email The email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the phone number
	 * @return The phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone number
	 * @param phone The phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the flight
	 * @return The flight
	 */
	public Flight getFlight() {
		return flight;
	}
	
	/**
	 * Sets the flight
	 * @param flight The flight
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	/**
	 * Gets the seat type
	 * @return The seat type
	 */
	public SeatType getSeatType() {
		return seatType;
	}
	
	/**
	 * Sets the seat type
	 * @param seatType The seat type
	 */
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", flight=" + flight + ", seatType=" + seatType + "]";
	}

}
