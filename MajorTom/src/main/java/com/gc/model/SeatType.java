package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents the SeatType table in the database, mapped with Hibernate
 */
@Entity
@Table(name = "SEAT_TYPE")
public class SeatType {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name = "SEAT_TYPE_ID")
	@SequenceGenerator(allocationSize = 1, name = "seatTypeSeq", sequenceName = "SEAT_TYPE_SEQ")
	@GeneratedValue(generator = "seatTypeSeq", strategy = GenerationType.SEQUENCE)
	Integer seatTypeId;
	
	/**
	 * The actual name of the seat type
	 */
	@Column(name="SEAT_TYPE_NAME")
	String seatTypeName;
	
	/**
	 * No-args constructor
	 */
	public SeatType() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param seatTypeId The id
	 * @param seatTypeName The name
	 */
	public SeatType(Integer seatTypeId, String seatTypeName) {
		super();
		this.seatTypeId = seatTypeId;
		this.seatTypeName = seatTypeName;
	}
	
	/**
	 * Gets the seat type id
	 * @return The seat type id
	 */
	public Integer getSeatTypeId() {
		return seatTypeId;
	}
	
	/**
	 * Sets the seat type id
	 * @param seatTypeId The seat type id
	 */
	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	
	/**
	 * Gets the seat type name
	 * @return The seat type name
	 */
	public String getSeatTypeName() {
		return seatTypeName;
	}
	
	/**
	 * Sets the seat type name
	 * @param seatTypeName The seat type name
	 */
	public void setSeatTypeName(String seatTypeName) {
		this.seatTypeName = seatTypeName;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "SeatType [seatTypeId=" + seatTypeId + ", seatTypeName=" + seatTypeName + "]";
	}
}
