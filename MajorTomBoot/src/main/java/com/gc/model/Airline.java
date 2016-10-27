package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents the Airline table in the database, mapped with Hibernate
 */
@Entity
@Table(name="AIRLINE")
public class Airline {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name="AIRLINE_ID")
	@SequenceGenerator(allocationSize=1,name="airlineSeq",sequenceName="AIRLINE_SEQ")
	@GeneratedValue(generator="airlineSeq",strategy=GenerationType.SEQUENCE)
	Integer airlineId;
	
	/**
	 * The name of the airline
	 */
	@Column(name="AIRLINE_NAME")
	String name;
	
	/**
	 * No-args constructor
	 */
	public Airline() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param name The name
	 */
	public Airline(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Gets the airline id
	 * @return The airline id
	 */
	public Integer getAirlineId() {
		return airlineId;
	}
	
	/**
	 * Sets the airline id
	 * @param airlineId The airline id
	 */
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	
	/**
	 * Gets the name
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", name=" + name + "]";
	}
	
}
