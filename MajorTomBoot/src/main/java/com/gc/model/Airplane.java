package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents the Airplane table in the database, mapped with Hibernate
 */
@Entity
@Table(name="AIRPLANE")
public class Airplane {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name="AIRPLANE_ID")
	@SequenceGenerator(allocationSize=1,name="destinationSeq",sequenceName="DESTINATION_SEQ")
	@GeneratedValue(generator="destinationSeq",strategy=GenerationType.SEQUENCE)
	Integer airplaneId;
	
	/**
	 * The name of the airplane
	 */
	@Column(name="AIRPLANE_NAME")
	String airplaneName;
	
	/**
	 * No-args constructor
	 */
	public Airplane() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param airplaneName The name
	 */
	public Airplane(String airplaneName) {
		super();
		this.airplaneName = airplaneName;
	}
	
	/**
	 * Gets the airplane id
	 * @return The airplane id
	 */
	public Integer getAirplaneId() {
		return airplaneId;
	}
	
	/**
	 * Sets airplane id
	 * @param airplaneId The airplane id
	 */
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	
	/**
	 * Gets the airplane name
	 * @return The airplane name
	 */
	public String getAirplaneName() {
		return airplaneName;
	}
	
	/**
	 * Sets the airplane name
	 * @param airplaneName The airplane name
	 */
	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", airplaneName=" + airplaneName + "]";
	}
}
