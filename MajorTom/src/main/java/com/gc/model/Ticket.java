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

@Entity
@Table(name="TICKET")
public class Ticket {
	@Id
	@Column(name="TICKET_ID")
	@SequenceGenerator(allocationSize=1,name="ticketSeq",sequenceName="TICKET_SEQ")
	@GeneratedValue(generator="ticketSeq",strategy=GenerationType.SEQUENCE)
	Integer ticketId;
	
	@Column(name="FIRST_NAME")
	String firstName;
	
	@Column(name="LAST_NAME")
	String lastName;
	
	@Column(name="EMAIL", length=1023)
	String email;
	
	@Column(name="PHONE", length=31)
	String phone;
	
	@OneToOne
	@JoinColumn(name="FLIGHT_ID")
	@Fetch(FetchMode.JOIN)
	Flight flight;
	
	@OneToOne
	@JoinColumn(name="SEAT_TYPE_ID")
	@Fetch(FetchMode.JOIN)
	SeatType seatType;
	
	public Ticket() {
		super();
	}
	public Ticket(String firstName, String lastName, String email, String phone, Flight flight, SeatType seatType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.flight = flight;
		this.seatType = seatType;
	}
	
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", flight=" + flight + ", seatType=" + seatType + "]";
	}

}
