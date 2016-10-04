package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	@JoinColumn(name="SEAT_ID")
	Seat seat;
	
	
	public Ticket() {
		super();
	}
	public Ticket(Integer ticketId, String firstName, String lastName, String email, String phone, Seat seat) {
		super();
		this.ticketId = ticketId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.seat = seat;
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
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", seat=" + seat + "]";
	}
}
